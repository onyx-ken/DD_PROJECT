package onyx.dd_project.visitor.service;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.visitor.domain.VisitHistory;
import onyx.dd_project.visitor.domain.Visitor;
import onyx.dd_project.visitor.repository.VisitHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VisitHistoryServiceImpl implements VisitHistoryService {

    private final VisitHistoryRepository visitorHistoryRepository;

    @Transactional
    @Override
    public void saveVisitHistory(Visitor visitor) {

        LocalDateTime nowTime = LocalDateTime.now();
        VisitHistory newVisitHistory = new VisitHistory();
        newVisitHistory.setHistoryDate(nowTime);

        Optional<VisitHistory> findVisitHistoryDay = visitorHistoryRepository.findByHistoryDate(nowTime.truncatedTo(ChronoUnit.DAYS));

        if (findVisitHistoryDay.isPresent()) {

            newVisitHistory.setDayCount(findVisitHistoryDay.get().getDayCount() +1L);

            newVisitHistory.setVisitor(newVisitHistory.getVisitor() + "," + visitor.getIpAddress());

            visitorHistoryRepository.save(newVisitHistory);

            return;
        }

        newVisitHistory.setDayCount(1L);

        newVisitHistory.setVisitor(visitor.getIpAddress());

        visitorHistoryRepository.save(newVisitHistory);

    }
}