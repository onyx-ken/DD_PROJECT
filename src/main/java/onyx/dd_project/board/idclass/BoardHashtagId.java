package onyx.dd_project.board.idclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BoardHashtagId implements Serializable {
    public Long board;
    public Long hashtag;

}
