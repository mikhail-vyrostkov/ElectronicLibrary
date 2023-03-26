package ru.vyrostkov.project1.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by @m.vyrostkov on 23.03.2023 21:15
 */
public class Book {

    private int id;

    @NotEmpty(message = "Название книги не долно быть пустым")
    @Size(min = 2, max = 100, message = "Поле должно быть не менее 2 и не более 100 символов")
    private String bookName;
    @NotEmpty(message = "Поле имя не долно быть пустым")
    @Size(min = 2, max = 30, message = "Имя автора должно быть не менее 2 и не более 30 символов")
    private String firstNameAuthor;

    @NotEmpty(message = "Поле фамилии не долно быть пустым")
    @Size(min = 2, max = 30, message = "Фамилия автора должна быть не менее 2 и не более 30 символов")
    private String lastNameAuthor;

    @Size(max = 30, message = "Отчество автора должно быть не более 30 символов")
    private String middleNameAuthor;


    @Min(value = 1500, message = "Год должен быть больше, чем 1500")
    private int yearOfPublishing;


    public Book() {
    }

    public Book(int id, String bookName, String firstNameAuthor, String lastNameAuthor, String middleNameAuthor, int yearOfPublishing) {
        this.id = id;
        this.bookName = bookName;
        this.firstNameAuthor = firstNameAuthor;
        this.lastNameAuthor = lastNameAuthor;
        this.middleNameAuthor = middleNameAuthor;
        this.yearOfPublishing = yearOfPublishing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getFirstNameAuthor() {
        return firstNameAuthor;
    }

    public void setFirstNameAuthor(String firstNameAuthor) {
        this.firstNameAuthor = firstNameAuthor;
    }

    public String getLastNameAuthor() {
        return lastNameAuthor;
    }

    public void setLastNameAuthor(String lastNameAuthor) {
        this.lastNameAuthor = lastNameAuthor;
    }

    public String getMiddleNameAuthor() {
        return middleNameAuthor;
    }

    public void setMiddleNameAuthor(String middleNameAuthor) {
        this.middleNameAuthor = middleNameAuthor;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

}
