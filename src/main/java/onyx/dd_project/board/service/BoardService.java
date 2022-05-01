package onyx.dd_project.board.service;

import onyx.dd_project.board.web.DiaryAddForm;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
    void saveDiary(DiaryAddForm diaryAddForm, HttpServletRequest httpServletRequest);
}
