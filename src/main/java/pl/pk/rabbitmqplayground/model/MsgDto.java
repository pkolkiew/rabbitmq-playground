package pl.pk.rabbitmqplayground.model;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public class MsgDto {
    private UUID messageId;
    private String messageBody;
    private LocalDateTime messageCreated;

    public MsgDto() {
    }

    public MsgDto(UUID messageId, String messageBody) {
        this.messageId = messageId;
        this.messageBody = messageBody;
        this.messageCreated = LocalDateTime.now();
    }

    public MsgDto(UUID messageId, String messageBody, LocalDateTime messageCreated) {
        this.messageId = messageId;
        this.messageBody = messageBody;
        this.messageCreated = messageCreated;
    }

    public UUID getMessageId() {
        return messageId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public LocalDateTime getMessageCreated() {
        return messageCreated;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public void setMessageCreated(LocalDateTime messageCreated) {
        this.messageCreated = messageCreated;
    }

}
