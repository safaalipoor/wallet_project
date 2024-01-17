import java.util.ArrayList;

public class user {
    static ArrayList<wallet> walletArrayList =new ArrayList<>();

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String userName;
    private int age;
    private String password;
    private wallet mywallet;


    public user(String firstName,String lastName,String address,String email,String userName,int age,String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.address=address;
        this.email=email;
        this.password=password;
        this.age=age;
    }

    public user() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
