package onyx.dd_project.hashtag.service;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.BoardHashtagR.BoardHashtagR;
import onyx.dd_project.BoardHashtagR.BoardHashtagRRepository;
import onyx.dd_project.board.domain.Board;
import onyx.dd_project.hashtag.domain.Hashtag;
import onyx.dd_project.hashtag.repository.HashtagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HashtagServiceImpl implements HashtagService{

    private final HashtagRepository hashtagRepository;

    private final BoardHashtagRRepository boardHashtagRRepository;

    @Transactional
    @Override
    public void saveHashtag(Board board, List<String> hashtags) {

        for (String stringHashtag : hashtags) {

            Optional<Hashtag> findByName = hashtagRepository.findByName(stringHashtag);

            if (findByName.isPresent()) {

                BoardHashtagR boardHashtagR = new BoardHashtagR();

                boardHashtagR.setBoard(board);
                boardHashtagR.setHashtag(findByName.get());

                boardHashtagRRepository.save(boardHashtagR);

            }else {

                Hashtag hashtag = new Hashtag();

                hashtag.setName(stringHashtag);

                Hashtag savedHashtag = hashtagRepository.save(hashtag);

                BoardHashtagR boardHashtagR = new BoardHashtagR();
                boardHashtagR.setBoard(board);
                boardHashtagR.setHashtag(savedHashtag);

                boardHashtagRRepository.save(boardHashtagR);

            }
        }
    }
}
