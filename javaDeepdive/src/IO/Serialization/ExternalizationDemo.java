package IO.Serialization;

import java.io.*;

public class ExternalizationDemo {

    public static void main (String[] args) throws IOException {
        // note that the password will be set to the 1234 value set in the User writeExternal() method
        User user = new User("testNickname", "testPassword");
        var byteArrayOutputStream = serializeUser(user);
        User copyUser = deserializeUser(byteArrayOutputStream);
        System.out.println(copyUser);
    }

    // this method serializes a User
    private static ByteArrayOutputStream serializeUser (User user) throws IOException {
        try (var byteArrayOutputStream = new ByteArrayOutputStream(); var objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(user);
            return byteArrayOutputStream;
        }
    }

    // this method deserializes a User
    private static User deserializeUser (ByteArrayOutputStream inputStream) throws IOException {
        try (var objectInputStream = new ObjectInputStream(new ByteArrayInputStream(inputStream.toByteArray()))) {
            return (User) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
