package onyx.dd_project.restrict.repository;

import onyx.dd_project.restrict.domain.Restrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestrictRepository extends JpaRepository<Restrict, Long> {

}
