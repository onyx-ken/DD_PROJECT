package onyx.dd_project.main;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.visitor.service.VisitorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final VisitorService visitorService;

    @GetMapping()
    public String main() {

        visitorService.saveVisitorAndHistory();


        return "index";
    }
}
