package onyx.dd_project.restrict.web;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class RestrictAddForm {

    @NotEmpty @Length(max = 48)
    private String ipAddress;

}
