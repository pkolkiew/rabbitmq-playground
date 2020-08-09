package pl.pk.rabbitmqplayground.infra.db;

import lombok.AllArgsConstructor;
import pl.pk.rabbitmqplayground.infra.MessageRepository;
import pl.pk.rabbitmqplayground.model.MsgDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author pkolkiew
 * Created 8/9/2020
 */
public class MessageSpringRepository implements MessageRepository {

    private final MessageSpringCrudRepository repository;

    public MessageSpringRepository(MessageSpringCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(MsgDto msgDto) {
        MessageEntity entity = MessageEntity.of(msgDto);
        repository.save(entity);
    }

    @Override
    public MsgDto findOne(UUID messageId) {
        Optional<MessageEntity> entityOptional = repository.findById(messageId);
        if(entityOptional.isPresent())
            return MessageEntity.of(entityOptional.get());
        return null;
    }

    @Override
    public List<MsgDto> findAll() {
        Iterable<MessageEntity> entities = repository.findAll();
        List<MsgDto> resultDtos = new ArrayList<>();
        entities.forEach(entity -> resultDtos.add(MessageEntity.of(entity)));
        return resultDtos;
    }
}
