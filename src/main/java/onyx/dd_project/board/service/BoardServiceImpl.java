package onyx.dd_project.board.service;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.board.repository.BoardRepository;
import onyx.dd_project.board.web.DiaryAddForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public void saveDiary(DiaryAddForm diaryAddForm, HttpServletRequest httpServletRequest) {

    }
}