package onyx.dd_project.board.service;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.board.domain.Board;
import onyx.dd_project.board.domain.BoardStatus;
import onyx.dd_project.board.repository.BoardRepository;
import onyx.dd_project.board.domain.BoardCategory;
import onyx.dd_project.board.web.DiaryAddForm;
import onyx.dd_project.board.web.DiaryUpdateForm;
import onyx.dd_project.common.util.IpManager;
import onyx.dd_project.hashtag.domain.Hashtag;
import onyx.dd_project.hashtag.repository.HashtagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    private final HashtagRepository hashtagRepository;

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


        Board savedDiary = boardRepository.save(diary);

        List<String> hashTags = diaryAddForm.getHashtag();

        for (String hashTag : hashTags) {

            Hashtag newHashtag = new Hashtag();

            newHashtag.setName(hashTag);

            hashtagRepository.save(newHashtag);



        }



        return savedDiary;

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