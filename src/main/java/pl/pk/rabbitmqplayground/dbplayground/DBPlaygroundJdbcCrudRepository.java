package pl.pk.rabbitmqplayground.dbplayground;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pkolkiew
 * Created 12/22/2021
 */
@Repository
interface DBPlaygroundJdbcCrudRepository extends CrudRepository<ParentEntity, Long> {



}
