package onyx.dd_project.restrict.domain;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "RESTRICT_SEQ_GENERATOR"
        , sequenceName = "RESTRICT_SEQ"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "RESTRICT")
public class Restrict {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "RESTRICT_SEQ_GENERATOR"
    )
    @Column(name = "RESTRICT_ID", nullable = false)
    private Long id;

    @Column(name = "RESTRICT_RULE")
    private RestrictRule restrictRule;

    @Column(name = "IP_ADRES", length = 48)
    private String ipAddress;

}
