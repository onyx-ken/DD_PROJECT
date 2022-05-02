package onyx.dd_project.comment.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class CommentAddForm {

    @NotEmpty @Length(max = 500)
    private String content;
    @NotEmpty @Length(max = 12)
    private String writer;
    @NotEmpty @Length(max = 16)
    private String password;

}
