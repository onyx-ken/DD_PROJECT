package onyx.dd_project.member.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "MEMBER")
public class Member {
    @Id
    @Column(name = "USER_ID")
    private String UserId;

    @Column(name = "PASSWORD", length = 150)
    private String password;

    @Column(name = "NC_NM", length = 12)
    private String nickName;

    @Column(name = "EMAIL_ADRES")
    private String emailAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private MemberRole memberRole;

}
