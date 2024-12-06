package IO.Serialization;

import java.io.*;
import java.util.Map;

public class Employee implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private Map<String, String> props;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getProps() {
        return props;
    }

    public void setProps(Map<String, String> props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", props=" + props +
                '}';
    }

    // this method gets executed by JVM when writeObject() is called during serialization
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        // perform any changes on the object before serializing it
        objectOutputStream.defaultWriteObject();
        System.out.println("Serialization is in progress");
    }

    // this method gets executed by JVM when writeObject() is called during deserialization
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        System.out.println("Deserialization in progress");
    }
}
