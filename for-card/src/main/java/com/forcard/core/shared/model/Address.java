package com.forcard.core.shared.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street;
    private String number;
    private String flat;
    private String town;
    private String zipCode;
    private String country;
    private LocalDate createdAt;
    private LocalDate modifiedAt;

    public Address(String street, String number, String flat, String town, String zipCode, String country) {
        this.street = street;
        this.number = number;
        this.flat = flat;
        this.town = town;
        this.zipCode = zipCode;
        this.country = country;
    }
}
