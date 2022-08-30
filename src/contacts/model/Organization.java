package contacts.model;

import contacts.Constants;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public void matcher(Record record) {
        int index = 1;
        Organization organization = (Organization) record;
        System.out.println(index + Constants.COMA_SEPARATOR + organization.getName());
    }

    @Override
    public List<Record> searchMatchingType(String query, Record record, List<Record> resultsList) {
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        Organization organization = (Organization) record;
        String find = organization.getName() + Constants.DELIMETER + organization.getPhoneNumber();
        Matcher matcher = pattern.matcher(find);
        if (matcher.find()) {
            resultsList.add(organization);
        }
        return resultsList;
    }
}
