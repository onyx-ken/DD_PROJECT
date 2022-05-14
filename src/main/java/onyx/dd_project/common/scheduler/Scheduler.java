package onyx.dd_project.common.scheduler;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.visitor.service.VisitorService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Scheduler {

    private final VisitorService visitorService;

    @Scheduled(cron = "0 0 0 1/1 * ?", zone = "Asia/Seoul")
    public void deleteTodayVisitor() {
        visitorService.deleteAllTodayVisitor();
    }

}
