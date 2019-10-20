package pl.pk.rabbitmqplayground.infra;

import pl.pk.rabbitmqplayground.model.MsgDto;

import java.util.List;
import java.util.UUID;

public interface MessageRepository {
    void save(MsgDto msgDto);
    MsgDto findOne(UUID messageId);
    List<MsgDto> findAll();
}
