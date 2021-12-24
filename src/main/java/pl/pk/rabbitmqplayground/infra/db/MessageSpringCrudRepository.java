package pl.pk.rabbitmqplayground.infra.db;

import java.util.Optional;
import java.util.UUID;

/**
 * @author pkolkiew
 * Created 8/9/2020
 */
public interface MessageSpringCrudRepository /*extends CrudRepository<MessageEntity, UUID> */ {
    void save(MessageEntity entity);

    Optional<MessageEntity> findById(UUID messageId);

    Iterable<MessageEntity> findAll();
}
