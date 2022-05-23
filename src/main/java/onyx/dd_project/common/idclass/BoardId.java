package onyx.dd_project.common.idclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import onyx.dd_project.board.domain.Board;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BoardId implements Serializable {
    public Long board;
    public Long BoardHistoryId;
}
