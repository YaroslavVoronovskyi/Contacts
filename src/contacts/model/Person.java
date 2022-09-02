package contacts.model;

import contacts.Constants;

import java.io.Serializable;

public class Person extends Record implements Serializable {

    private static final long serialVersionUID = 1L;
    private String surname;
    private String birthDate;
    private String gender;

    public Person(String name, String surname, String birthDate, String gender) {
        super(name);
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ")
                .append(name)
                .append(Constants.LINE_SEPARATOR)
                .append("Surname: ")
                .append(surname)
                .append(Constants.LINE_SEPARATOR)
                .append("Birth date: ")
                .append(birthDate)
                .append(Constants.LINE_SEPARATOR)
                .append("Gender: ")
                .append(gender)
                .append(Constants.LINE_SEPARATOR)
                .append("Number: ")
                .append(phoneNumber)
                .append(Constants.LINE_SEPARATOR)
                .append("Time created: ")
                .append(creationDate)
                .append(Constants.LINE_SEPARATOR)
                .append("Time last edit: ")
                .append(lastEditDate);
        return builder.toString();
    }

    @Override
    public void printListRecord(int index) {
        System.out.println(index + Constants.DOT_SEPARATOR + name + Constants.DELIMETER + surname);
    }

    @Override
    public boolean specificMatches(String pattern) {
        return name.contains(pattern) || surname.contains(pattern);
    }

    @Override
    public String getEditRecordFieldMessage() {
        return "Select a field (name, surname, birth, gender, number): ";
    }
}
