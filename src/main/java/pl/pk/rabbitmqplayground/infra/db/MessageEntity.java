package pl.pk.rabbitmqplayground.infra.db;

import lombok.*;
import pl.pk.rabbitmqplayground.model.MsgDto;


import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author pkolkiew
 * Created 8/9/2020
 */
//@Entity(name = "MESSAGE_ENTITY")
@Getter
@Builder
@EqualsAndHashCode
class MessageEntity implements Serializable {
//    @Id
    private UUID uuid;
    private String content;
    private LocalDateTime saveTime;
//    @Version
    private Timestamp timestamp;

    public MessageEntity() {
    }

    public MessageEntity(UUID uuid, String content, LocalDateTime saveTime, Timestamp timestamp) {
        this.uuid = uuid;
        this.content = content;
        this.saveTime = saveTime;
        this.timestamp = timestamp;
    }

    public static MessageEntity of(MsgDto msgDto) {
        return new MessageEntity(UUID.randomUUID(), msgDto.getMessageBody(), msgDto.getMessageCreated(), Timestamp.from(Instant.now()));
    }

    public static MsgDto of(MessageEntity messageEntity) {
        return MsgDto.builder()
                .messageId(messageEntity.getUuid())
                .messageBody(messageEntity.getContent())
                .messageCreated(messageEntity.getSaveTime())
                .build();
    }
}






















