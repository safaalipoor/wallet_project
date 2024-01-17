import java.time.LocalDate;
import java.util.Random;
import java.util.*;
import java.util.ArrayList;
public class main {
    static Scanner input=new Scanner(System.in);
    private static user newuser =new user();
    private static wallet newwallet=new wallet();
    private static transaction trs=new transaction();
    static ArrayList<user> userArrayList =new ArrayList<>();
    static ArrayList<wallet> walletArrayList =new ArrayList<>();
    static ArrayList<transaction> transactionsArrayList =new ArrayList<>();
    static ArrayList<transaction> transactionsArrayList1 =new ArrayList<>();

    static int accnum;
    static boolean condition;
    static Random random=new Random();

    public static void main(String[] args) {
       int q=1;
        for (int i = 0; i < 10; i++) {
            q *= 10;
        }
        String ramz ;
        boolean status;
        double money;
        while(true){
        printmenu();
        int gozine= input.nextInt();
            switch (gozine) {
                case 1:
                    System.out.println("enter your firstname :");
                    String firstname = input.next();
                    newuser.setFirstName(firstname);
                    System.out.println("enter your lastname :");
                    String lastname = input.next();
                    newuser.setLastName(lastname);
                    System.out.println("enter your username :");
                    String username = input.next();
                    newuser.setUserName(username);
                    System.out.println("enter your address :");
                    String address = input.next();
                    newuser.setAddress(address);
                    System.out.println("enter your email :");
                    String email = input.next();
                    newuser.setEmail(email);
                    System.out.println("enter your age :");
                    int age = input.nextInt();
                    newuser.setAge(age);
                    System.out.println("enter your password :");
                    String password = input.next();
                    newuser.setPassword(password);
                    userArrayList.add(newuser);
                    System.out.println("your account was created successfully .");
                    break;
                case 2:
                    System.out.println("please enter your username :");
                    String u =input.next();
                    System.out.println("please enter your password :");
                    String p =input.next();
                    if (u.equals(newuser.getUserName()) && p.equals(newuser.getPassword())) {
                        while (true) {
                            printmenu1();
                            int gozine1 = input.nextInt();
                            switch (gozine1){
                                case 1:
                                    accnum = random.nextInt(q);
                                    LocalDate enteredDate = LocalDate.of(2021,12,30);
                                    createwallet(enteredDate,accnum,q);
                                    break;

                                case 2:
                                    if (!exp()){
                                        System.out.println("your wallet has expired!");
                                        break;
                                    }
                                    System.out.println("please enter wallet password:");
                                    ramz=input.next();
                                    status=enterwallet(ramz);
                                    if (status) {
                                        System.out.println("enter the wallet name you want to delete :");
                                        String r =input.next();
                                        delete(ramz);
                                        //deletetrs(r);
                                        System.out.println("The wallet successfully removed.");
                                    }
                                    else {
                                        System.out.println("the password is not correct !");
                                    }
                                    break;
                                case 3:
                                    if (!exp()){
                                        System.out.println("your wallet has expired!");
                                        break;
                                    }
                                    System.out.println("please enter wallet password:");
                                    ramz=input.next();
                                    status=enterwallet(ramz);
                                    if (status) {
                                        System.out.println("enter new wallet name :");
                                        String newwalletname = input.next();
                                        exchangename(newwalletname,ramz);
                                    }
                                    else {
                                        System.out.println("the password is not correct !");
                                    }
                                    break;
                                case 4:
                                    transaction.Status d1;
                                    if (!exp()){
                                        System.out.println("your wallet has expired!");
                                        d1= transaction.Status.FAILED;

                                        break;
                                    }
                                    System.out.println("please enter wallet password:");
                                    ramz=input.next();
                                    status=enterwallet(ramz);
                                    if (status) {
                                        System.out.println("how much money do you want to deposit??");
                                        money = input.nextDouble();
                                        findanddeposit1(ramz,money);
                                        int transactionid1 = random.nextInt(100000);
                                        transaction.Type d= transaction.Type.DEPOSIT;
                                        d1= transaction.Status.ACCEPTED;
                                        Date date =new Date();
                                        transaction trs =new transaction(transactionid1,newwallet,date,d,d1,money);
                                        transactionsArrayList.add(trs);
                                        System.out.println("Done.");
                                    }
                                    else {
                                        System.out.println("the password is not correct !");
                                    }
                                    break;
                                case 5:
                                    transaction.Status v;
                                    if (!exp()){
                                        System.out.println("your wallet has expired!");
                                        v= transaction.Status.FAILED;
                                        break;
                                    }
                                    System.out.println("please enter wallet password:");
                                    ramz=input.next();
                                    status=enterwallet(ramz);
                                    if (status) {
                                        System.out.println("how much money do you want to withdraw??");
                                        money = input.nextDouble();
                                        findandwithdraw1(ramz,money);
                                        int transactionid2 = random.nextInt(100000);
                                        transaction.Type n= transaction.Type.WITHDRAW;
                                        v= transaction.Status.ACCEPTED;
                                        Date date1 =new Date();
                                        transaction trs =new transaction(transactionid2,newwallet,date1,n,v,money);
                                        transactionsArrayList.add(trs);
                                        System.out.println("Done.");
                                    }
                                    else {
                                        System.out.println("the password is not correct !");
                                    }
                                    break;
                                case 6:
                                    if (!exp()){
                                        System.out.println("your wallet has expired!");
                                        break;
                                    }
                                    System.out.println("please enter wallet password:");
                                    ramz=input.next();
                                    status=enterwallet(ramz);
                                    if (status) {
                                        printbalance(ramz);
                                    }
                                    else {
                                        System.out.println("the password is not correct !");
                                    }
                                    break;
                                case 7:
                                    transaction.Status v1;
                                    if (!exp()){
                                        System.out.println("your wallet has expired!");
                                        v1= transaction.Status.FAILED;
                                        break;
                                    }
                                    System.out.println("please enter wallet password:");
                                    ramz=input.next();
                                    status=enterwallet(ramz);
                                    if (status){
                                        System.out.println("how much money do you want to transfer??");
                                        money=input.nextDouble();
                                        System.out.println("enter the recipient account number:");
                                        int ti=input.nextInt();
                                        newwallet.withdraw(money);
                                        findanddeposit(ti,money);
                                        findandwithdraw(ramz,money);
                                        v1=transaction.Status.ACCEPTED;
                                        transaction.Type n1=transaction.Type.TRANSFER;
                                        Date datee=new Date();
                                        transaction trs=new transaction(ti,datee,n1,v1,money);
                                        transactionsArrayList.add(trs);
                                        System.out.println("Done.");
                                    }
                                    break;

                                case 8:
                                    print();
                                    break;
                                case 9:
                                    System.out.println("please enter the name of the wallet" +
                                            " whose transactions you want to view :");
                                    String a= input.next();
                                    pr(a);
                                    break;

                                case 10:
                                    return;
                            }
                        }
                    }
                    else
                        System.out.println("your username and password are incorrect" +
                                " and if you have not already registered please register. ");
                        break;
                case 3:
                    return;
            }
        }
    }
    public static void printmenu(){
        System.out.println("1.Register ");
        System.out.println("2.Login ");
        System.out.println("3.exit");
    }
    public static void printmenu1(){
        System.out.println("1.create wallet");
        System.out.println("2.delete wallet");
        System.out.println("3.rename wallet");
        System.out.println("4.deposit money");
        System.out.println("5.withdraw money");
        System.out.println("6.view balance");
        System.out.println("7.transfer money");
        System.out.println("8.view transactions related to user");
        System.out.println("9.view transactions related to each wallet");
        System.out.println("10.log out");
    }
    public static boolean exp(){
        boolean e =true;
        LocalDate nowDate =LocalDate.now();
        LocalDate enteredDate = LocalDate.of(2026,12,30);
        if (enteredDate.isBefore(nowDate)){
            newwallet.setCondition(false);
            e=false;
        }
        return e;
    }
    public static boolean enterwallet(String password){
        boolean ramz = false;
        System.out.println("enter the name of the wallet you want to enter:");
        String n=input.next();
        for (wallet namee : walletArrayList) {
            if (n.equals(namee.getName())){
                if( password.equals(newwallet.getPassword()));{
                    ramz=true;
                    break;
                }
            }
        }
        return ramz;
    }
    public static void findandwithdraw(String password,double  money){
        for (int i = 0; i < walletArrayList.size(); i++) {
            if (password.equals(walletArrayList.get(i).getPassword())){
                walletArrayList.get(i).withdraw(money);
                trs.setReceiver(walletArrayList.get(i));

            }
        }

    }
    public static void findandwithdraw1(String password,double  money){
        for (int i = 0; i < walletArrayList.size(); i++) {
            if (password.equals(walletArrayList.get(i).getPassword())){
                walletArrayList.get(i).withdraw(money);
            }
        }

    }
    public static void findanddeposit(int an,double money){
        for (int i = 0; i < walletArrayList.size(); i++) {
           if( walletArrayList.get(i).getAccountnumber()==an){
               walletArrayList.get(i).deposit(money);
               trs.setDepositor(walletArrayList.get(i));

           }
        }

    }
    public static void findanddeposit1(String ramz,double money){
        for (int i = 0; i < walletArrayList.size(); i++) {
            if(ramz.equals(walletArrayList.get(i).getPassword())){
                walletArrayList.get(i).deposit(money);

            }
        }

    }
    public static void createwallet( LocalDate exp, int accnum,int q){
        System.out.println("enter wallet name :");
        String walletname = input.next();
        newwallet.setName(walletname);
        accnum = random.nextInt(q);
        newwallet.setAccountnumber(accnum);
        System.out.println("enter wallet password :");
        String pass = input.next();
        newwallet.setPassword(pass);
        condition = true;
        newwallet.setCondition(condition);
        wallet newwallet=new wallet(walletname,condition,exp,accnum,pass);
        walletArrayList.add(newwallet);
        System.out.println("your wallet was created successfully .");
        System.out.println("your account number is :" + newwallet.getAccountnumber());

    }
    public static void exchangename(String n,String ramz){
        for (int i = 0; i < walletArrayList.size(); i++) {
            if (ramz.equals(walletArrayList.get(i).getPassword())){
                walletArrayList.get(i).exchange(n);
                walletArrayList.get(i).setName(n);
            }
        }
    }
    public static void print(){
        for (int i = 0; i < transactionsArrayList.size(); i++) {
            System.out.println("transaction " +(i+1) + ":");
            System.out.println("transaction ID :" + transactionsArrayList.get(i).getTransactionId());
            System.out.println("receiver wallet :" + transactionsArrayList.get(i).getReceiver());
            System.out.println("depositor wallet :" + transactionsArrayList.get(i).getDepositor());
            System.out.println("transaction type :" + transactionsArrayList.get(i).getN());
            System.out.println("transaction status :" + transactionsArrayList.get(i).getV());
            System.out.println("transaction amount:" + transactionsArrayList.get(i).getAmount());
            System.out.println("transaction time :" + transactionsArrayList.get(i).getTime());
            System.out.println("------------------------------------------------");
        }
    }
    public static void printbalance(String ramz ){
        for (int i = 0; i < walletArrayList.size(); i++) {
            if(ramz.equals(walletArrayList.get(i).getPassword())){
                System.out.println("your account balance is :" + walletArrayList.get(i).getBalance());

            }
        }
    }
    public static void delete(String ramz ){
        for (int i = 0; i < walletArrayList.size(); i++) {
            if(ramz.equals(walletArrayList.get(i).getPassword())){
                walletArrayList.remove(i);
            }
        }
    }
    /*public static void deletetrs(String w){
        for (int i = 0; i < transactionsArrayList.size(); i++) {
            String r=transactionsArrayList.get(i).getReceiver().getName();
            String r1 = transactionsArrayList.get(i).getDepositor().getName();
            if (r.equals(w) || r1.equals(w)){
                transactionsArrayList.remove(i);
            }

        }

    }*/
    public static void pr(String name){
        for (int i = 0; i < walletArrayList.size(); i++) {
            if (walletArrayList.get(i).getName().equals(name)){
                for (int j = 0; j < transactionsArrayList.size(); j++) {
                    if (trs.getDepositor().getName().equals(name) || trs.getReceiver().getName().equals(name)){
                        System.out.println("transaction " +(j+1) + ":");
                        System.out.println("transaction ID :" + transactionsArrayList.get(j).getTransactionId());
                        System.out.println("receiver wallet :" + transactionsArrayList.get(j).getReceiver());
                        System.out.println("depositor wallet :" + transactionsArrayList.get(j).getDepositor());
                        System.out.println("transaction type :" + transactionsArrayList.get(j).getN());
                        System.out.println("transaction status :" + transactionsArrayList.get(j).getV());
                        System.out.println("transaction amount:" + transactionsArrayList.get(j).getAmount());
                        System.out.println("transaction time :" + transactionsArrayList.get(j).getTime());
                        System.out.println("------------------------------------------------");
                    }
                }
            }
        }

    }

}