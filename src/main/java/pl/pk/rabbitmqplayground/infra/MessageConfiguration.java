package pl.pk.rabbitmqplayground.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pk.rabbitmqplayground.infra.db.MessageSpringCrudRepository;
import pl.pk.rabbitmqplayground.infra.db.MessageSpringRepository;

@Configuration
class MessageConfiguration {

    MessageRepository messageRepository() {
        return new InMemoryMessageRepository();
    }

    @Bean
    MessageRepository messageSpringRepository(MessageSpringCrudRepository repository) {
        return new MessageSpringRepository(repository);
    }

}
