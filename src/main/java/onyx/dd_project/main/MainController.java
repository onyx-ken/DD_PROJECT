package onyx.dd_project.main;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.board.domain.Board;
import onyx.dd_project.board.domain.BoardCategory;
import onyx.dd_project.board.repository.BoardRepository;
import onyx.dd_project.board.web.DiaryAddForm;
import onyx.dd_project.visitor.domain.Visitor;
import onyx.dd_project.visitor.repository.VisitHistoryRepository;
import onyx.dd_project.visitor.repository.VisitorRepository;
import onyx.dd_project.visitor.service.VisitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final VisitorService visitorService;

    private final VisitHistoryRepository visitHistoryRepository;

    private final VisitorRepository visitorRepository;

    private final BoardRepository boardRepository;

    @GetMapping()
    public String main(Model model) {

        visitorService.saveVisitorAndHistory();

        long allVisitedUser = visitHistoryRepository.count();

        long TodayVisitedUser = visitorRepository.count();

        model.addAttribute("allVisitedUser", allVisitedUser);

        model.addAttribute("TodayVisitedUser", TodayVisitedUser);

        model.addAttribute("writeForm", new DiaryAddForm());

        // diary List show

        List<Board> diaryList = boardRepository.findAllByCategory(BoardCategory.DIARY);

        model.addAttribute("diaryList", diaryList);

        return "index";
    }
}
