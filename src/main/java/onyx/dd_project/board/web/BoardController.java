package onyx.dd_project.board.web;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.board.domain.Board;
import onyx.dd_project.board.repository.BoardRepository;
import onyx.dd_project.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
public class BoardController {

    static final String TEMPLATES_PATH = "/board/diary/";

    private final BoardRepository boardRepository;

    private final BoardService boardService;



    @GetMapping("/diary/list")
    public String diaryList(Model model) {

        List<Board> diaryList = boardRepository.findAllByCategory(BoardCategory.DIARY);

        model.addAttribute("diaryList", diaryList);

        return TEMPLATES_PATH + "diaryList";
    }

    @GetMapping("/diary/{id}")
    public String detailDiary(@PathVariable Long id, Model model) {

        Optional<Board> findDiary = boardRepository.findById(id);

        Board diaryDetail = findDiary.orElse(null);

        model.addAttribute("diaryDetail", diaryDetail);

        return TEMPLATES_PATH + "diaryDetail";

    }

    @GetMapping("/diary/add")
    public String viewDiaryAddForm() {


        return TEMPLATES_PATH + "diaryAddForm";
    }

    @PostMapping("/diary/add")
    public String addDiary(DiaryAddForm diaryAddForm) {

        Board saveDiary = boardService.saveDiary(diaryAddForm);

        Long saveDiaryId = saveDiary.getId();

        return "redirect:/diary/" + saveDiaryId;
    }

    @GetMapping("/diary/update/{id}")
    public String viewDiaryUpdateForm(@PathVariable Long id) {


        return TEMPLATES_PATH + "/diaryUpdateForm";
    }

    @PostMapping("/diary/update/{id}")
    public String updateDiary(@PathVariable Long id, DiaryUpdateForm diaryUpdateForm) {

        Board updateDiary = boardService.updateDiary(diaryUpdateForm, id);

        return "redirect:/diary/" + updateDiary;
    }

}
