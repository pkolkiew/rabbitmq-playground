package pl.pk.rabbitmqplayground.dbplayground;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author pkolkiew
 * Created 12/21/2021
 */
@AllArgsConstructor
public class DBPlaygroundFacade {

    private final DBPlaygroundRepository repository;
    private final DBPlaygroundJdbcCrudRepository crudRepository;

    public void save() {
        Set<ChildEntity> childEntitySet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            ChildEntity childEntity = ChildEntity.builder()
                    .username("username " + i)
                    .insertDate(LocalDateTime.now())
                    .build();
            childEntitySet.add(childEntity);
        }

        ParentEntity parentEntity = ParentEntity.builder()
                .username("username 123")
                .insertDate(LocalDateTime.now())
                .childs(childEntitySet)
                .build();

        Long parentId = repository.saveAll(parentEntity);
    }

    public ParentEntity findById() {
        return crudRepository.findById(1L).stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Blad podczas pobierania danych z DB"));
    }
}
