package com.techphantoms.registration.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorldMessage implements Serializable {
    private String id;
    private String msg;
}
