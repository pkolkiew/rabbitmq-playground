package pl.pk.rabbitmqplayground.infra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pk.rabbitmqplayground.model.MsgDto;
import pl.pk.rabbitmqplayground.producer.MessageSource;

@Slf4j
@RestController
@RequestMapping("/message")
@EnableBinding(MessageSource.class)
class MessageController {

    private MessageSource messageSource;

    public MessageController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @PostMapping("/publish")
    public void publishMessage(@RequestBody MsgDto msgDto) {
        try {
            messageSource.create1().send(MessageBuilder.withPayload(msgDto).build());
            log.info("Msg to "+messageSource.OUTPUT1 +" published");
            messageSource.create2().send(MessageBuilder.withPayload(msgDto).build());
            log.info("Msg to "+messageSource.OUTPUT2+" published");
        } catch (Exception e) {
            log.error("Blad przekazania wiadomosci do kolejki");
        }
    }


}
