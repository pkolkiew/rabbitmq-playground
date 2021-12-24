package pl.pk.rabbitmqplayground.producer;

//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.messaging.MessageChannel;

public interface MessageSource {

    String OUTPUT1 = "output1";
    String OUTPUT2 = "output2";

//    @Output(OUTPUT1)
//    MessageChannel create1();
//
//    @Output(OUTPUT2)
//    MessageChannel create2();
}
