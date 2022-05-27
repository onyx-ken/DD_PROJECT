package onyx.dd_project.boardHistory.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import onyx.dd_project.board.domain.Board;
import onyx.dd_project.common.idclass.BoardId;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@SequenceGenerator(
        name = "BOARD_HISTORY_SEQ_GENERATOR"
        , sequenceName = "BOARD_HISTORY_SEQ"
        , allocationSize = 1
)
@Getter
@Setter
@ToString
@Table(name = "BOARD_HISTORY")
@IdClass(BoardId.class)
public class BoardHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "BOARD_HISTORY_SEQ_GENERATOR"
    )
    @Column(name = "BOARD_HISTORY_ID", nullable = false)
    private Long BoardHistoryId;

    @Id
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @Column(name = "BOARD_HISTORY_DT")
    private LocalDateTime historyDate;

    @Lob
    @Column(name = "READ_IP_ADRES")
    private String readIpAddress;

    @Column(name = "DAY_COUNT")
    private Long dayCount = 0L;

    @Column(name = "DAY_LIKES")
    private Long dayLikes = 0L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BoardHistory that = (BoardHistory) o;
        return BoardHistoryId != null && Objects.equals(BoardHistoryId, that.BoardHistoryId)
                && board != null && Objects.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(BoardHistoryId, board);
    }
}
