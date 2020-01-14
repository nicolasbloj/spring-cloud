package com.nab.messages;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@ToString
@Document(collection = "messages")
public class Message {

    @Id
    private String id;
    @NotBlank
    private String text;
}
