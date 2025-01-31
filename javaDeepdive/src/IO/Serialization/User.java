package IO.Serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class User implements Externalizable {

    // the two fields implemented by Externalizable
    private String nickname;
    private String password;

    public User() {

    }

    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void writeExternal (ObjectOutput out) throws IOException {
        out.writeObject(this.nickname);
        out.writeObject("1234"); // we can encrypt password here
    }

    @Override
    public void readExternal (ObjectInput in) throws IOException, ClassNotFoundException {
        this.nickname = (String) in.readObject();
        this.password = (String) in.readObject(); // wen can decrypt password here
    }
}
