package contacts.model;

import contacts.Constants;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person extends Record {
    private String surname;
    private String birthDate;
    private String gender;

    public Person(String name, String surname, String birthDate, String gender) {
        super(name);
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public int hashCode() {
        return Objects.hash(surname, birthDate, gender);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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
    public void matcher(Record record) {
        int index = 1;
        Person person = (Person) record;
        System.out.println(index + Constants.COMA_SEPARATOR + person.getName() + Constants.DELIMETER + person.getSurname());
    }

    @Override
    public List<Record> searchMatchingType(String query, Record record, List<Record> resultsList) {
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        Person person = (Person) record;
        String find = person.getName() + Constants.DELIMETER + person.getSurname() + Constants.DELIMETER + person.getPhoneNumber();
        Matcher matcher = pattern.matcher(find);
        if (matcher.find()) {
            resultsList.add(person);
        }
        return resultsList;
    }
}
