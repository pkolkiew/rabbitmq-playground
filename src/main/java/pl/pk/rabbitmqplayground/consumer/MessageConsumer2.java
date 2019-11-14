package pl.pk.rabbitmqplayground.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import pl.pk.rabbitmqplayground.infra.MessageRepository;
import pl.pk.rabbitmqplayground.model.MsgDto;

/**
 * @author pkolkiew
 * Created 10/20/2019
 */
@Slf4j
@EnableBinding(MyConsumer.class)
class MessageConsumer2 {

    private MessageRepository messageRepository;

    public MessageConsumer2(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @StreamListener(target = MyConsumer.INPUT2)
    public void processRegisterEmployees(MsgDto msgDto) {
        messageRepository.save(msgDto);
        log.info("Msg from '" + MyConsumer.INPUT2 + ": MsgDto.getMessageBody(): " + msgDto.getMessageBody());
    }

}
