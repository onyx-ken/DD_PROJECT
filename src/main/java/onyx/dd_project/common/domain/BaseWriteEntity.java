package onyx.dd_project.common.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseWriteEntity {

    @Column(name = "WRITNG_DT")
    private LocalDateTime writeDate;

    @Column(name = "UPDT_DT")
    private LocalDateTime updateDate;

    @Type(type="yes_no")
    @Column(name = "USE_AT")
    private Boolean useAt;

    @Column(name = "WRITNG_IP_ADRES", length = 40)
    private String WriteIpAddress;

    @Column(name = "UPDT_IP_ADRES", length = 40)
    private String updateIpAddress;

}
