import java.time.LocalDate;
public class wallet {
    private String name;
    private boolean condition;
    private LocalDate exp;
    private int accountnumber ;
    private String password;
    private double balance = 0.0;


    public wallet(String name, boolean condition, LocalDate exp, int accountnumber, String password){
        this.name=name;
        this.condition=condition;
        this.exp=exp;
        this.accountnumber=accountnumber;
        this.password=password;

    }

    public wallet() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public LocalDate getExp() {
        return exp;
    }

    public void setExp(LocalDate exp) {
        this.exp = exp;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void deposit (double money){
        balance += money ;
    }
    public void withdraw (double money){
            balance -= money;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void printbalance(){
        System.out.println(balance);
    }
    public void exchange(String n){
        this.name=n;
    }
}
