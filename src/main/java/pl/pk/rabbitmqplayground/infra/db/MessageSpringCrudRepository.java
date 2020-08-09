package pl.pk.rabbitmqplayground.infra.db;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author pkolkiew
 * Created 8/9/2020
 */
public interface MessageSpringCrudRepository extends CrudRepository<MessageEntity, UUID> {
}
