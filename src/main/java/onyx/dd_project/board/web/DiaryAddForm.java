package onyx.dd_project.board.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DiaryAddForm {

    @NotEmpty @Length(max = 50)
    private String subject;

    @NotEmpty
    private String content;

    @NotEmpty @Length(max = 12)
    private String nickName;

    @NotEmpty @Length(max = 16)
    private String password;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate occurredDate;

    private Boolean publicAt;

}
