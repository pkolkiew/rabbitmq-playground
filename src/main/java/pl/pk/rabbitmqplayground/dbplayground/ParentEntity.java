package pl.pk.rabbitmqplayground.dbplayground;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

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
@Table("parent_table")
class ParentEntity implements Serializable {
    @Id
    private Long parId;
    private String username;
    private LocalDateTime modifyDate;
    @NonNull
    private LocalDateTime insertDate;

    @MappedCollection(keyColumn = "par_id", idColumn = "par_par_id")
    private Set<ChildEntity> childs;
}
