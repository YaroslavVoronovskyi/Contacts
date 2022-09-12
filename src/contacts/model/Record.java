package contacts.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Record implements Serializable {

    private static final long serialVersionUID = 1L;
    protected String id;
    protected String name;
    protected String phoneNumber;
    protected LocalDateTime creationDate;
    protected LocalDateTime lastEditDate;

    public Record(String name) {
        this.id = generateId();
        this.name = name;
    }

    public String getId() {
        return id;
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

    public abstract void printRecord(int index);

    public boolean matches(String pattern) {
        boolean matches = false;
        if (name.contains(pattern)) {
            matches = true;
        }
        return matches || specificMatches(pattern);
    }

    public abstract boolean specificMatches(String pattern);

    public abstract String getEditRecordFieldMessage();

    public String generateId() {
        String uuid = UUID.randomUUID().toString();
        id = uuid;
        return id;
    }
}
