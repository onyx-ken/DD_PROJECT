package onyx.dd_project.comment.repository;

import onyx.dd_project.board.domain.Board;
import onyx.dd_project.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
    List<Comment> findAllByBoard(Board board);
}
