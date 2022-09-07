package contacts.util;

import contacts.Constants;
import contacts.model.Record;

import java.io.*;
import java.util.List;

public class SerializationUtil {
    public static void serializeObject(List<Record> phoneBook) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Constants.FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Record currentRecord : phoneBook) {
                objectOutputStream.writeObject(currentRecord);
            }
            objectOutputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
