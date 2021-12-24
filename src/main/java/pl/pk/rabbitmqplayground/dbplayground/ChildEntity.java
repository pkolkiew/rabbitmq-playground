package pl.pk.rabbitmqplayground.dbplayground;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author pkolkiew
 * Created 12/21/2021
 */
//@Builder
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@Data
@Builder
@Table("child_table")
class ChildEntity implements Serializable {
    @Id
    private Long chiId;
    private Long parParId;
    private String username;
    private LocalDateTime modifyDate;
    @NonNull
    private LocalDateTime insertDate;

//    void setParentId(Long parentId) {
//        this.parParId = parentId;
//    }
}
