package onyx.dd_project.board.idclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import onyx.dd_project.board.domain.Board;
import onyx.dd_project.hashtag.domain.Hashtag;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BoardHashtagId implements Serializable {
    public Board board;
    public Hashtag hashtag;

}
