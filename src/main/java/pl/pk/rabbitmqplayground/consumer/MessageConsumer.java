package pl.pk.rabbitmqplayground.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import pl.pk.rabbitmqplayground.model.MsgDto;
import pl.pk.rabbitmqplayground.infra.MessageRepository;

@Slf4j
@EnableBinding(MyConsumer.class)
class MessageConsumer {

    @Autowired
    private MessageRepository messageRepository;

    @StreamListener(target = MyConsumer.INPUT)
    public void processRegisterEmployees(MsgDto msgDto) {
        messageRepository.save(msgDto);
        log.info("Msg from '"+MyConsumer.INPUT+": MsgDto.getMessageBody(): " + msgDto.getMessageBody());
    }

}
