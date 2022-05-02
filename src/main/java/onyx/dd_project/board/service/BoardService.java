package onyx.dd_project.board.service;

import onyx.dd_project.board.domain.Board;
import onyx.dd_project.board.web.DiaryAddForm;
import onyx.dd_project.board.web.DiaryUpdateForm;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
    Board saveDiary(DiaryAddForm diaryAddForm);
    Board updateDiary(DiaryUpdateForm diaryUpdateForm, Long id);
}