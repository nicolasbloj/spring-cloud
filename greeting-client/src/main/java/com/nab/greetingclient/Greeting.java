package com.nab.greetingclient;


import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonRootName("greeting")
@Getter
@AllArgsConstructor
public class Greeting {

    protected String content;

    /**
     * Default constructor
     */
    protected Greeting() {
        this.content = "Hello!";
    }

}

