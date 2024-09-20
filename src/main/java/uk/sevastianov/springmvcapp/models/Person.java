package uk.sevastianov.springmvcapp.models;
import jakarta.validation.constraints.*;

//import org.hibernate.validator.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message = "Name couldn't be empty!")
    @Size(min = 2, max = 15, message = "Name length is not correct!")
    private String name;
    @Min(value = 0, message = "Age could not be negative!")
    private int age;
    @NotEmpty(message = "Email couldn't be empty!")
    @Email(message = "Email should be valid")
    private String email;

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }


    public Person(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
