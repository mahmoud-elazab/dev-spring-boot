package com.melazab.mvc;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
    private String firstName;

    @NotNull(message = "Last Name is required")
    @Size(min = 1, message = "Size must be at least 1 character")
    private  String lastName;

    @Min(value = 1, message = "you must have at least 1 module")
    @Max(value = 5, message = "you must have maximum 5 modules")
    private int modules;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getModules() {
        return modules;
    }

    public void setModules(int modules) {
        this.modules = modules;
    }
}
