package com.example.reservasibioskop.dto;

import lombok.*;

@Getter
@Setter
public class MessageModel {
    private Integer status;
    private String message;
    private Object data;
}
