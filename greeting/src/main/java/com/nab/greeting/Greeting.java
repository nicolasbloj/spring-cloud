package com.nab.greeting;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class Greeting implements Serializable {

    private final String content;

}
