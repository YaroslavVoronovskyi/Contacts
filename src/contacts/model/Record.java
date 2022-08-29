package contacts.model;

import contacts.Constants;

import java.time.LocalDateTime;

public abstract class Record {

    protected String name;
    protected String phoneNumber;
    protected LocalDateTime creationDate;
    protected LocalDateTime lastEditeDate;

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

    public LocalDateTime getLastEditeDate() {
        return lastEditeDate;
    }

    public void setLastEditeDate(LocalDateTime lastEditeDate) {
        this.lastEditeDate = lastEditeDate;
    }

    @Override
    public String toString() {
        return name + Constants.DELIMETER + phoneNumber
                + Constants.DELIMETER + creationDate + Constants.DELIMETER + lastEditeDate;
    }
}
