package onyx.dd_project.board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import onyx.dd_project.board.idclass.BoardHashtagId;
import onyx.dd_project.hashtag.domain.Hashtag;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@IdClass(BoardHashtagId.class)
@Table(name = "BOARD_HASHTAG_R")
public class BoardHashtagR {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    @ToString.Exclude
    private Board board;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HASHTAG_ID")
    @ToString.Exclude
    private Hashtag hashtag;

}
