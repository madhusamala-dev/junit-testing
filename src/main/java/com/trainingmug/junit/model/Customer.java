package com.trainingmug.junit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Customer {
    private int id;
    private String name;
    private String email;
    private double balance;
}
