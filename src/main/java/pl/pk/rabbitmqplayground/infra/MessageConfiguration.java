package pl.pk.rabbitmqplayground.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import pl.pk.rabbitmqplayground.infra.db.MessageSpringCrudRepository;
import pl.pk.rabbitmqplayground.infra.db.MessageSpringRepository;

@Configuration
class MessageConfiguration {

    MessageRepository messageRepository() {
        return new InMemoryMessageRepository();
    }

    @Bean
    MessageRepository messageSpringRepository() {
        return new MessageSpringRepository();
    }

    @Bean
    MessageJdbcRepository messageJdbcRepository(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        return new MessageJdbcSpringRepository(namedParameterJdbcOperations);
    }

    @Bean
    JdbcCustomConversions jdbcCustomConversions(){
        return new JdbcCustomConversions();
    }

}
