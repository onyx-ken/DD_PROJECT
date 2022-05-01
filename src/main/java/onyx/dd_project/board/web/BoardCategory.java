package onyx.dd_project.board.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum BoardCategory {
    DIARY("일기장"),
    NOTICE("공지"),
    FREE("자유")
    ;

    private String korean;
}
