package pl.pk.rabbitmqplayground.consumer;

import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
import pl.pk.rabbitmqplayground.infra.MessageRepository;
import pl.pk.rabbitmqplayground.model.MsgDto;

@Slf4j
//@EnableBinding(MyConsumer.class)
class MessageConsumer {

    private MessageRepository messageRepository;

    public MessageConsumer(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

//    @StreamListener(target = MyConsumer.INPUT1)
    public void processRegisterEmployees(MsgDto msgDto) {
        messageRepository.save(msgDto);
        log.info("Msg from '" + MyConsumer.INPUT1 + ": MsgDto.getMessageBody(): " + msgDto.getMessageBody());
    }

}
