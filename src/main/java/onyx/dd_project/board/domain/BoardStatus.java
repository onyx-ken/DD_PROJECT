package onyx.dd_project.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum BoardStatus {
    TEMP("임시저장"),
    COM("작성완료"),
    ;

    private String korean;
    
}
