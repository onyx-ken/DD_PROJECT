package onyx.dd_project.visitor.service;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.common.util.IpManager;
import onyx.dd_project.visitor.domain.Visitor;
import onyx.dd_project.visitor.repository.VisitorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VisitorServiceImpl implements VisitorService{

    private final VisitorRepository visitorRepository;

    private final VisitHistoryService visitHistoryService;

    private final IpManager ipManager;

    @Transactional
    @Override
    public Optional<Visitor> saveVisitor() {

        String ip = ipManager.getIp();

        Optional<Visitor> findVisitor = visitorRepository.findByIpAddress(ip);

        if(findVisitor.isPresent()) {

            return Optional.empty();
        }

        Visitor visitor = new Visitor();

        visitor.setIpAddress(ip);

        return Optional.of(visitorRepository.save(visitor));

    }

    @Transactional
    @Override
    public void saveVisitorAndHistory() {

        Optional<Visitor> visitor = saveVisitor();
        visitor.ifPresent(visitHistoryService::saveVisitHistory);

    }
}