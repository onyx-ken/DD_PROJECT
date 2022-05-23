package onyx.dd_project.hashtag.repository;

import onyx.dd_project.hashtag.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long>, HashtagRepositoryCustom {
    Optional<Hashtag> findByName(String hashtag);
}
