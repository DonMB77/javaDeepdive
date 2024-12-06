package IO.Serialization;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Serialization {

    public static void main (String[] args) throws IOException {
        Employee empl = new Employee();
        empl.setId(1);
        empl.setName("Don");
        Map<String, String> props = new HashMap<>();
        props.put("monthlySalary" , "4000");
        props.put("city", "Berlin");
        empl.setProps(props);

        var byteArrayOutputStream = serializeEmployee(empl);
        Employee copyOfEmployee = deserializeEmployee(byteArrayOutputStream);
        System.out.println(copyOfEmployee);
    }

    // this method serializes an employee
    private static ByteArrayOutputStream serializeEmployee (Employee employee) throws IOException {
        try (var byteArrayOutputStream = new ByteArrayOutputStream(); var objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(employee);
            return byteArrayOutputStream;
        }
    }

    // this method deserializes an employee
    private static Employee deserializeEmployee (ByteArrayOutputStream inputStream) throws IOException {
        try (var objectInputStream = new ObjectInputStream(new ByteArrayInputStream(inputStream.toByteArray()))) {
            return (Employee) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
