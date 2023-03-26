package ru.vyrostkov.project1.models;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author Mikhail Vyrostkov
 */
public class Person {
    private int id;

    @NotEmpty(message = "Поле имя не долно быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть не менее 2 и не более 30 символов")
    private String firstName;

    @NotEmpty(message = "Поле фамилии не долно быть пустым")
    @Size(min = 2, max = 30, message = "Фамилия должна быть не менее 2 и не более 30 символов")
    private String lastName;

    @Size( max = 30, message = "Отчество должно быть не более 30 символов")
    private String middleName;

    @Pattern(regexp = "\\d{2}.\\d{2}.\\d{4}", message = "Дата рождения должна быть записана в формате: дд.мм.гггг")
    private String birthday;

    @NotEmpty(message = "Укажите адрес почты")
    @Email(message = "Email должен былть валидным")
    private String email;
    @Pattern(regexp = "^\\+?[78][-\\(]?\\d{3}\\)?-?\\d{3}-?\\d{2}-?\\d{2}$", message = "Номер телефона должн быть записан в допустимых форматах: 89103123167; +7-910-221-22-22; +7(910)-221-22-22")
    private String phone;

    private byte[] photo;



    public Person() {

    }

    public Person(int id, String firstName, String lastName, String middleName, String birthday, String email, String phone, byte[] photo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
