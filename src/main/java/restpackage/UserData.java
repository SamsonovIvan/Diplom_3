package restpackage;

public class UserData {
    private String email;
    private String password;

    public UserData(String email, String password){
        this.email = email;
        this.password = password;
    }

    public static UserData from(User user){
        return new UserData(user.getEmail(), user.getPassword());
    }

    public static UserData from(String email, String password){
        return new UserData(email, password);
    }

    @Override
    public String toString(){
        return "UserData{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
