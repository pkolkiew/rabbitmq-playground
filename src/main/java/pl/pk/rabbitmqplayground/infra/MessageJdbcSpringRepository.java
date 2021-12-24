package pl.pk.rabbitmqplayground.infra;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

/**
 * @author pkolkiew
 * Created 12/21/2021
 */
@AllArgsConstructor
class MessageJdbcSpringRepository implements MessageJdbcRepository {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

}
