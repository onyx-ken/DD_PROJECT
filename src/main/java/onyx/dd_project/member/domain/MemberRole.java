package onyx.dd_project.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum MemberRole {
    NORMAL("일반회원"),
    ADMIN("관리자"),
    TEMP("임시회원"),
    SUSPEND("임시정지회원"),
    EXPEL("영구정지회원"),
    RESIGN("탈퇴회원"),
    ;

    private String korean;
}
