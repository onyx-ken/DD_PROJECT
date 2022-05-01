package onyx.dd_project.boardHistory.domain;

import onyx.dd_project.board.domain.Board;
import onyx.dd_project.common.idclass.BoardId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(
        name = "BOARD_HISTORY_SEQ_GENERATOR"
        , sequenceName = "BOARD_HISTORY_SEQ"
        , allocationSize = 1
)
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
    private Long dayCount;

    @Column(name = "DAY_LIKES")
    private Long dayLikes;

}
