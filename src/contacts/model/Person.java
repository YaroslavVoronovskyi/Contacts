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

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Name: " + name + Constants.LINE_SEPARATOR + "Surname: " + surname + Constants.LINE_SEPARATOR +
                "Birth date: " + birthDate + Constants.LINE_SEPARATOR + "Gender: " + gender + Constants.LINE_SEPARATOR +
                "Number: " + phoneNumber + Constants.LINE_SEPARATOR + "Time created: " +
                creationDate.format(Constants.DATE_TIME_FORMAT) + Constants.LINE_SEPARATOR + "Time last edit: " +
                lastEditDate.format(Constants.DATE_TIME_FORMAT);
    }

    @Override
    public void printRecord(int index) {
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
