package contacts.model;

import contacts.Constants;

import java.io.Serializable;

public class Organization extends Record implements Serializable {

    private static final long serialVersionUID = 1L;
    private String address;

    public Organization(String name, String address) {
        super(name);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization name: " + name + Constants.LINE_SEPARATOR + "Address: " + address + Constants.LINE_SEPARATOR +
                "Number: " + phoneNumber + Constants.LINE_SEPARATOR + "Time created: " +
                creationDate.format(Constants.DATE_TIME_FORMAT) + Constants.LINE_SEPARATOR + "Time last edit: " +
                lastEditDate.format(Constants.DATE_TIME_FORMAT);
    }

    @Override
    public void printRecord(int index) {
        System.out.println(index + Constants.DOT_SEPARATOR + name);
    }

    @Override
    public boolean specificMatches(String pattern) {
        return name.contains(pattern);
    }

    @Override
    public String getEditRecordFieldMessage() {
        return "Select a field (address, number):";
    }
}
