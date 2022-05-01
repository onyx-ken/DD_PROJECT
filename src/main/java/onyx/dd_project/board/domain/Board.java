package onyx.dd_project.board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import onyx.dd_project.board.web.BoardCategory;
import onyx.dd_project.common.domain.BaseWriteEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SequenceGenerator(
        name = "BOARD_SEQ_GENERATOR"
        , sequenceName = "BOARD_SEQ"
        , allocationSize = 1
)
@Table(name = "BOARD")
public class Board extends BaseWriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "BOARD_SEQ_GENERATOR"
    )
    @Column(name = "BOARD_ID", nullable = false)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "BOARD_CTGRY", length = 30)
    private BoardCategory category;

    @Column(name = "BOARD_SJ", length = 50)
    private String subject;

    @Lob
    @Column(name = "BOARD_CN")
    private String content;

    @Column(name = "BOARD_NC_NM", length = 12)
    private String nickName;

    @Column(name = "BOARD_PASSWORD", length = 150)
    private String password;

    @Type(type="yes_no")
    @Column(name = "PULBIC_AT")
    private Boolean publicAt;

    @Type(type="yes_no")
    @Column(name = "ADULT_AT")
    private Boolean adultAt;

    @Column(name = "BOARD_COUNT")
    private Long count;

    @Column(name = "BOARD_LIKES")
    private Long likes;

    @Column(name = "OCCRRNC_DT")
    private LocalDate occurredDate;
}