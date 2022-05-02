package onyx.dd_project.comment.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import onyx.dd_project.board.domain.Board;
import onyx.dd_project.common.domain.BaseWriteEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SequenceGenerator(
        name = "COMENT_SEQ_GENERATOR"
        , sequenceName = "COMENT_SEQ"
        , allocationSize = 1
)
@Table(name = "COMENT")
public class Comment extends BaseWriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "COMENT_SEQ_GENERATOR"
    )
    @Column(name = "COMENT_ID", nullable = false)
    private Long id;

    @Column(name = "COMENT_CN", length = 500)
    private String content;

    @Column(name = "COMENT_WRTER", length = 20)
    private String writer;

    @Column(name = "COMENT_PASSWORD", length = 150)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    @ToString.Exclude
    private Board board;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(content, comment.content) && Objects.equals(writer, comment.writer) && Objects.equals(board, comment.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, writer, board);
    }
}