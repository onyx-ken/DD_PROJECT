package onyx.dd_project.memberHistory.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import onyx.dd_project.member.domain.MemberRole;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SequenceGenerator(
        name = "MEMBER_HISTORY_SEQ_GENERATOR"
        , sequenceName = "MEMBER_HISTORY_SEQ"
        , allocationSize = 1
)
@Table(name = "MEMBER_HISTORY")
public class MemberHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "MEMBER_HISTORY_SEQ_GENERATOR"
    )
    @Column(name = "MEMBER_HISTORY_ID")
    private Long id;

    @Column(name = "LOGIN_DT")
    private LocalDateTime loginTime;

    @Column(name = "LOGIN_IP", length = 48)
    private String ipAddress;

}
