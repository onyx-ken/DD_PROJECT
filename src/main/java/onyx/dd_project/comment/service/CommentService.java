package onyx.dd_project.comment.service;

import onyx.dd_project.comment.web.CommentAddForm;
import onyx.dd_project.comment.web.CommentUpdateForm;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    void saveComment(CommentAddForm commentAddForm);
    void updateComment(CommentUpdateForm commentUpdateForm, Long id);
    void deleteComment(Long id);
}
