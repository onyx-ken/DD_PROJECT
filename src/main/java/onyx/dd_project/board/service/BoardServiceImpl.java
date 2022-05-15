package onyx.dd_project.board.service;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.board.domain.Board;
import onyx.dd_project.board.domain.BoardStatus;
import onyx.dd_project.board.repository.BoardRepository;
import onyx.dd_project.board.domain.BoardCategory;
import onyx.dd_project.board.web.DiaryAddForm;
import onyx.dd_project.board.web.DiaryUpdateForm;
import onyx.dd_project.common.util.IpManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    private final IpManager ipManager;

    @Transactional
    @Override
    public Board saveDiary(DiaryAddForm diaryAddForm) {

        Board diary = new Board();

        diary.setCategory(BoardCategory.DIARY);
        diary.setBoardStatus(BoardStatus.COM);
        diary.setSubject(diaryAddForm.getSubject());
        diary.setContent(diaryAddForm.getContent());
        diary.setNickName(diaryAddForm.getNickName());
        diary.setPassword(diaryAddForm.getPassword());
        diary.setOccurredDate(diaryAddForm.getOccurredDate());
        diary.setWriteDate(LocalDateTime.now());
        diary.setWriteIpAddress(ipManager.getIp());

        return boardRepository.save(diary);

    }

    @Transactional
    @Override
    public Board updateDiary(DiaryUpdateForm diaryUpdateForm, Long id) {

        Optional<Board> findDiary = boardRepository.findById(id);

        Board updateDiary = findDiary.orElse(null);

        updateDiary.setSubject(diaryUpdateForm.getSubject());
        updateDiary.setContent(diaryUpdateForm.getContent());
        updateDiary.setPublicAt( diaryUpdateForm.getPublicAt());

        return updateDiary;

    }

    @Transactional
    @Override
    public void deleteDiary(Long id) {

        Optional<Board> findDiary = boardRepository.findById(id);

        Board deleteDiary = findDiary.orElse(null);

        deleteDiary.setUseAt(false);
    }
}