package pl.pk.rabbitmqplayground.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author pkolkiew
 * Created 10/20/2019
 */
public interface MyConsumer {
    String INPUT1 = "input1";
    String INPUT2 = "input2";

    @Input(INPUT1)
    SubscribableChannel input1();

    @Input(INPUT2)
    SubscribableChannel input2();
}
