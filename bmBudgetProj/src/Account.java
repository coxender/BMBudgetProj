
/**
 * Write a description of class Accounts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account{   
    private int balanceCents;
    String accountName;

    public Account(int balance, String name){//constructor
        this.accountName=name;
        this.balanceCents=balance;

    }

    public void setBalance(int balanceCents){
        this.balanceCents=balanceCents;
    }
    public void addBalance(int balanceCents){
    this.balanceCents=balanceCents+this.balanceCents;
    }

    public int getBalance(){
        return balanceCents;
    }

    public void setName(String name){
        this.accountName=name;
    }

    public static String getName(Account r){
        return (r.accountName);
    }

    public String toString(){
        double dollars=balanceCents/100.0;
        return String.format("Name: %10sBalance: $%6.2f",accountName,dollars);
    }

}
