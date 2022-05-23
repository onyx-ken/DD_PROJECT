package onyx.dd_project.BoardHashtagR;

import onyx.dd_project.board.domain.Board;
import onyx.dd_project.board.idclass.BoardHashtagId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardHashtagRRepository extends JpaRepository<BoardHashtagR, Board> {
}
