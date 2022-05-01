package onyx.dd_project.visitor.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SequenceGenerator(
        name = "VISIT_HISTORY_SEQ_GENERATOR"
        , sequenceName = "VISIT_HISTORY_SEQ"
        , allocationSize = 1
)
@Table(name = "VISIT_HISTORY")
public class VisitHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "VISIT_HISTORY_SEQ_GENERATOR"
    )
    @Column(name = "VISIT_HISTORY_ID", nullable = false)
    private Long id;

    @Column(name = "DAY_COUNT")
    private Long dayCount;

    @Column(name = "VISIT_HISTORY_DAY")
    private LocalDateTime historyDate;

    @Lob
    @Column(name = "VISITOR_LIST")
    private String visitor;

}