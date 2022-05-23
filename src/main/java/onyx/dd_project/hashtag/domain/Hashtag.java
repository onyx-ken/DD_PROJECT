package onyx.dd_project.hashtag.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import onyx.dd_project.common.domain.BaseWriteEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SequenceGenerator(
        name = "HASHTAG_SEQ_GENERATOR"
        , sequenceName = "HASHTAG_SEQ"
        , allocationSize = 1
)
@Table(name = "HASHTAG")
public class Hashtag extends BaseWriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "HASHTAG_SEQ_GENERATOR"
    )
    @Column(name = "HASHTAG_ID", nullable = false)
    private Long id;

    @Column(name = "HASHTAG_NM", length = 50)
    private String name;

}