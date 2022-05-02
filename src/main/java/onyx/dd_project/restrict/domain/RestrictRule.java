package onyx.dd_project.restrict.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum RestrictRule {
    ALL("전체"),
    DIARY("일기장"),
    FREE("자유게시판")
    ;

    private String korean;
}
