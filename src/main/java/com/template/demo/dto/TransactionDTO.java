package com.template.demo.dto;

import lombok.Data;

@Data
public class TransactionDTO {
    private Integer activityCode;
    private String insertBy;
    private String insertDate;
}
