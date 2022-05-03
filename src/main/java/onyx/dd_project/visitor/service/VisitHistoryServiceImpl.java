package onyx.dd_project.visitor.service;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.visitor.domain.VisitHistory;
import onyx.dd_project.visitor.domain.Visitor;
import onyx.dd_project.visitor.repository.VisitHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VisitHistoryServiceImpl implements VisitHistoryService {

    private final VisitHistoryRepository visitorHistoryRepository;

    @Transactional
    @Override
    public void saveVisitHistory(Visitor visitor) {

        VisitHistory visitHistory = new VisitHistory();
        visitHistory.setIpAddress(visitor.getIpAddress());
        visitHistory.setHistoryDate(LocalDateTime.now());

        visitorHistoryRepository.save(visitHistory);

    }
}