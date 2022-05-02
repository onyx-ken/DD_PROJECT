package onyx.dd_project.comment.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class CommentUpdateForm {

    @NotEmpty @Length(max = 500)
    private String content;

}
