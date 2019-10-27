package com.nab.greeting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
public class Greeting implements Serializable {

    private final String content;

    protected String port;

    protected String property;

}
