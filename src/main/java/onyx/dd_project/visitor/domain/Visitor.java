package onyx.dd_project.visitor.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

@Table(name = "VISITOR")
public class Visitor {
    @Id
    @Column(name = "IP_ADRES", length = 48)
    private String ipAddress;

}
