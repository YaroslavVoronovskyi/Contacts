package contacts.model;

import contacts.Constants;

public class Organization extends Record {
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
        StringBuilder builder = new StringBuilder();
        builder.append("Organization name: ")
                .append(name)
                .append(Constants.LINE_SEPARATOR)
                .append("Address: ")
                .append(address)
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
        System.out.println(index + Constants.DOT_SEPARATOR + name);
    }

    @Override
    public boolean specificMatches(String pattern) {
        return name.contains(pattern);
    }
}
