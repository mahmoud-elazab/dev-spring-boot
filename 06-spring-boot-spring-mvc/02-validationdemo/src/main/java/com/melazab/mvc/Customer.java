package com.melazab.mvc;

import com.melazab.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull(message = "Last Name is required")
    @Size(min = 1, message = "Size must be at least 1 character")
    private  String lastName;

    @NotNull(message = "Number of Modules is required")
    @Min(value = 0, message = "number of modules must be between 0 and 5")
    @Max(value = 5, message = "number of modules can't be more than 5")
    private Integer modules;

    @NotNull(message = "Postal Code is required")
    @Pattern(regexp="^[a-zA-Z0-9]{5}", message ="Only 5 chars/digits")
    private String postalCode;

    @CourseCode(value = "RUB", message= "Course code must start with RUB")
    private  String courseCode;

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

    public Integer getModules() {
        return modules;
    }

    public void setModules(Integer modules) {
        this.modules = modules;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
