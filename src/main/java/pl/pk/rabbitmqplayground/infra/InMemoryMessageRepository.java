package pl.pk.rabbitmqplayground.infra;

import pl.pk.rabbitmqplayground.model.MsgDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

class InMemoryMessageRepository implements MessageRepository {

    private List<MsgDto> msgDtoList;

    public InMemoryMessageRepository() {
        if(this.msgDtoList == null)
            this.msgDtoList = new ArrayList<>();
    }

    @Override
    public void save(MsgDto msgDto) {
        this.msgDtoList.add(msgDto);
    }

    @Override
    public MsgDto findOne(UUID messageId) {
        Optional<MsgDto> result = this.msgDtoList.stream().filter(s -> s.getMessageId().equals(messageId)).findFirst();
        return (!result.isPresent() ? null : result.get());
    }

    @Override
    public List<MsgDto> findAll() {
        return this.msgDtoList;
    }
}
