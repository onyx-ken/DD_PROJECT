package onyx.dd_project.hashtag.service;

import onyx.dd_project.board.domain.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HashtagService {
    void saveHashtag(Board board, List<String> hashtags);
}
