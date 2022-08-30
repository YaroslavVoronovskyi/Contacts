package contacts.model;

import java.time.LocalDateTime;

public abstract class Record {

    protected String name;
    protected String phoneNumber;
    protected LocalDateTime creationDate;
    protected LocalDateTime lastEditDate;
    private boolean isPerson;

    public Record(String name) {
        this.name = name;
    }

    public boolean setPerson(boolean person) {
        isPerson = person;
        return person;
    }

    public boolean isPerson() {
        return isPerson;
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

    public boolean matches(String pattern) {
        boolean matches = false;
        if (name.contains(pattern)) {
            matches = true;
        }
        return matches || specificMatches(pattern);
    }

    public abstract boolean specificMatches(String pattern);
}
