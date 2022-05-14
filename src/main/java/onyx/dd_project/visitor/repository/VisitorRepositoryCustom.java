package onyx.dd_project.visitor.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface VisitorRepositoryCustom {

    @Modifying
    @Query(value = "truncate table VISITOR", nativeQuery = true)
    void truncateVisitorTable();
}
