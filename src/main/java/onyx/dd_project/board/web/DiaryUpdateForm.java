package onyx.dd_project.board.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class DiaryUpdateForm {

    @NotEmpty
    @Length(max = 50)
    private String subject;

    @NotEmpty
    private String content;

    private Boolean publicAt;

    private Boolean adultAt;

}
