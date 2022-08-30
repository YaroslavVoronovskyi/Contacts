package contacts.model;

import contacts.Constants;

import java.time.LocalDateTime;

public abstract class Record {

    protected String name;
    protected String phoneNumber;
    protected LocalDateTime creationDate;
    protected LocalDateTime lastEditDate;

    private boolean isPerson;

    public boolean isPerson() {
        return isPerson;
    }

    public Record() {
    }

    public boolean setPerson(boolean person) {
        isPerson = person;
        return person;
    }

    public Record(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(LocalDateTime lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    @Override
    public String toString() {
        return name + Constants.DELIMETER + phoneNumber
                + Constants.DELIMETER + creationDate + Constants.DELIMETER + lastEditDate;
    }
}
