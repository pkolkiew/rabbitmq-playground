package pl.pk.rabbitmqplayground.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MessageConfiguration {

    @Bean
    MessageRepository messageRepository(){
        return new InMemoryMessageRepository();
    }

}
