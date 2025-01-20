import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class sUser {
    private String username;
    private String password;
    private String Id;
    private String phonenumber;

    public sUser(String username, String password, String id, String phonenumber) {
        this.username = username;
        this.password = password;
        Id = id;
        this.phonenumber = phonenumber;
    }

    public sUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


}
