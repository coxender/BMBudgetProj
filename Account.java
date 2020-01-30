
/**
 * Write a description of class Accounts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account{   
    private int balanceCents;
    String accountName;
    private boolean credit=false;
    
    public Account(int balance, String name,String type){
        this.accountName=name;
        this.balanceCents=balance*100;
        if(type.equals("credit")){
            credit=true;
        }
    }
    
    public void setBalance(int balanceCents){
        this.balanceCents=balanceCents;
    }
    
    public int getBalance(){
        return balanceCents;
    }
    
    public String toString(){
        double dollars=balanceCents/100.0;
        return String.format("Name: %10sBalance: $%6.2f",accountName,dollars);
    }
}
