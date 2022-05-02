package onyx.dd_project.board.repository;

import onyx.dd_project.board.domain.Board;
import onyx.dd_project.board.web.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
    List<Board> findAllByCategory(BoardCategory boardCategory);
}
