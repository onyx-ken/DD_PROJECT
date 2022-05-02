package onyx.dd_project.comment.service;

import lombok.RequiredArgsConstructor;
import onyx.dd_project.comment.domain.Comment;
import onyx.dd_project.comment.repository.CommentRepository;
import onyx.dd_project.comment.web.CommentAddForm;
import onyx.dd_project.comment.web.CommentUpdateForm;
import onyx.dd_project.common.util.IpManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final IpManager ipManager;

    @Transactional
    @Override
    public void saveComment(CommentAddForm commentAddForm) {

        Comment comment = new Comment();

        comment.setContent(commentAddForm.getContent());
        comment.setWriter(commentAddForm.getWriter());
        comment.setPassword(commentAddForm.getPassword());

        comment.setWriteDate(LocalDateTime.now());
        comment.setWriteIpAddress(ipManager.getIp());

        commentRepository.save(comment);

    }

    @Transactional
    @Override
    public void updateComment(CommentUpdateForm commentUpdateForm, Long id) {
        Optional<Comment> findComment = commentRepository.findById(id);

        Comment comment = findComment.orElse(null);

        comment.setContent(commentUpdateForm.getContent());

    }

    @Override
    public void deleteComment(Long id) {
        Optional<Comment> findComment = commentRepository.findById(id);

        Comment comment = findComment.orElse(null);

        comment.setUseAt(false);

    }
}
