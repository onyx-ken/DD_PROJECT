package onyx.dd_project.boardHistory.service;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.board.domain.Board;
import onyx.dd_project.boardHistory.domain.BoardHistory;
import onyx.dd_project.boardHistory.repository.BoardHistoryRepository;
import onyx.dd_project.common.util.IpManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardHistoryImpl implements BoardHistoryService{

    private final BoardHistoryRepository boardHistoryRepository;

    private final IpManager ipManager;

    @Override
    public void readBoard(Board board) {

        String readIp = ipManager.getIp();

        if (readIp.equals(board.getWriteIpAddress())  || readIp.equals(board.getUpdateIpAddress())) { // 작성자 혹은 수정자인 경우 카운트 X

            return;
        }

        Optional<BoardHistory> findBoard = boardHistoryRepository.findByBoard(board);

        if (findBoard.isPresent()) {
            BoardHistory boardHistory = findBoard.get();
            String[] readIpList = boardHistory.getReadIpAddress().split(",");
            boolean isRead = Arrays.asList(readIpList).contains(readIp); // 읽은 아이피 리스트에 있을 경우 카운트 X

            if (isRead) {

            }else {

                if(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS) == boardHistory.getHistoryDate().truncatedTo(ChronoUnit.DAYS)) { // 날짜 같은지 확인

                    BoardHistory newBoardHistory = new BoardHistory();
                    newBoardHistory.setBoard(board);
                    newBoardHistory.setHistoryDate(LocalDateTime.now());
                    newBoardHistory.setReadIpAddress(readIp);

                }else {

                    boardHistory.setDayCount(boardHistory.getDayCount() + 1L);
                    boardHistory.setDayLikes(boardHistory.getDayLikes() + 1L);
                    boardHistory.setReadIpAddress(boardHistory.getReadIpAddress() + "," + readIp);
                }
            }
        }
    }
}
