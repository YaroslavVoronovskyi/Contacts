package contacts.model;

import java.io.IOException;
import java.time.LocalDateTime;

public abstract class Record {

    protected String name;
    protected String phoneNumber;
    protected LocalDateTime creationDate;
    protected LocalDateTime lastEditDate;

    public boolean isPerson() {
        return isPerson;
    }

    public void setPerson(boolean person) {
        isPerson = person;
    }
    protected boolean isPerson = false;

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

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastEditDate(LocalDateTime lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public abstract void printListRecord(int index);

    public boolean chooseRecordForEdit(String pattern) {
        boolean matches = false;
        if (name.contains(pattern)) {
            matches = true;
        }
        return matches || specificMatches(pattern);
    }

    public abstract boolean specificMatches(String pattern);
}
