package in.apptozee.calc.calc.movieinfo.model;

/**
 * Created by amareshjana on 27/03/17.
 */

public class UserModel {

    private String username ="";
    private String password ="";
    private String mobileNo ="";
    private String email ="";
    private String fullName ="";

    public UserModel(String username, String password, String mobileNo, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.mobileNo = mobileNo;
        this.email = email;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }
}
