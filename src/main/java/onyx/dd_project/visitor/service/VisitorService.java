package onyx.dd_project.visitor.service;

import onyx.dd_project.visitor.domain.Visitor;

import java.util.Optional;

public interface VisitorService {
    Optional<Visitor> saveVisitor();
    public void saveVisitorAndHistory();
}