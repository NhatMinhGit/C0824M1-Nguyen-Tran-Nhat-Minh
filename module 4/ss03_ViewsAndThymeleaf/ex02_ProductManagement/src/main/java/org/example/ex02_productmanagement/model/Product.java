package org.example.ex02_productmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String manufacture;


}
