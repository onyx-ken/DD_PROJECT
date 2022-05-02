package onyx.dd_project.boardHistory.repository;

import onyx.dd_project.board.domain.Board;
import onyx.dd_project.boardHistory.domain.BoardHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardHistoryRepository extends JpaRepository<BoardHistory, Long> {

    Optional<BoardHistory> findByBoard(Board board);
}