import java.util.Date;

public class transaction {

    private int transactionId;
    private wallet depositor;
    private wallet receiver;
    private Date time;
    private double amount;

    public transaction() {

    }

    enum Type{
        DEPOSIT,WITHDRAW,TRANSFER;
    }
    enum Status{
        FAILED,ACCEPTED;
    }
    Type N;
    Status V;

    public transaction(int transactionId,wallet depositor,wallet receiver,Date time,Type N,Status V,double amount){
        this.transactionId=transactionId;
        this.depositor=depositor;
        this.receiver=receiver;
        this.time=time;
        this.N=N;
        this.V=V;
        this.amount=amount;
    }
    public transaction(int transactionId, wallet receiver, Date time,Type N,Status V,double amount){
        this.transactionId=transactionId;
        this.receiver=receiver;
        this.time=time;
        this.N=N;
        this.V=V;
        this.amount=amount;

    }
    public transaction(int transactionId, Date time,Type N,Status V,double amount){
        this.transactionId=transactionId;
        this.time=time;
        this.N=N;
        this.V=V;
        this.amount=amount;

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public wallet getDepositor() {
        return depositor;
    }

    public void setDepositor(wallet depositor) {
        this.depositor = depositor;
    }

    public wallet getReceiver() {
        return receiver;
    }

    public void setReceiver(wallet receiver) {
        this.receiver = receiver;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Type getN() {
        return N;
    }

    public void setN(Type n) {
        N = n;
    }

    public Status getV() {
        return V;
    }

    public void setV(Status v) {
        V = v;
    }
    public String toString(){
        return ("transaction id:"+this.getTransactionId()+
                " transaction status: "+ this.V +
                " transaction type " + this.N +
                " time : "+ this.time );
    }

}
