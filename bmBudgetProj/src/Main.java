

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Write a description of class Demo here.
 *
 * @Chiara Oxender
 * @0.1
 */
public class Main
{

    /**
     * Displays the arrays containing each category and its budgeted amount. 
     * @param the category array, and the amount array.
     * @return void
     */
    public static void display(String[][] cat, Account[] account){
        for(int i=0;i<cat.length;i++){
            if(cat[i][1]==null){
                while(i<account.length){
                System.out.println("\t\t" + account[i]);
                i=i+1;

                }
                System.out.print("EOF");   
                break;
            }
            System.out.printf("\t [%d]%s\n\t\t$%.2f.",i+1,cat[i][0],Integer.parseInt(cat[i][1])/100.0);
            System.out.println("\t\t" + account[i]);
        }
    }

    public static void catcher(Scanner in){
        while(!in.hasNextDouble()){
            in.nextLine();
            
        }
    }

    private static int check(Scanner in,int length){//method that catches inputMismatch and other
        int accountHold=0;
        String loopBug;
        loopBug=in.next();
        if(loopBug.contains("[a-zA-Z]")){
            in.nextLine();
            System.out.print("\n Please input an account number");
        }
        accountHold=Integer.parseInt(loopBug);
        in.nextLine();
        if(accountHold>=length||accountHold<0){
            System.out.println("invalid account");
            return(-1);}
        System.out.println("Account Number handeled");
        return(accountHold);     
    }
    
    public static String optionsMenu(Account[] account, Scanner in, String[][] cat,String allMemo){
    	
        final String OPTIONS=String.format("\nPossible Actions:\n"+
                "[1] INFLOW\n"+
                "[2] OUTFLOW\n"+
                "[3] TRANSFER BETWEEN CATEGORY\n"+
                "[4] SET UP AUTOMATIC INFLOW DIST*\n"+
                "[5] ADD  A NEW CATEGORY\n"+
                "[6] ADD A NEW ACCOUNT\n"+
                "[7] ADD A GOAL*\n"+
                "[8] SAVE AND EXIT\n\n"+

                "Enter Action Number: ");

        System.out.println(OPTIONS);
        
        
        final int CENTS = 100;
        final double DOLLARS=1/100.0;
        int i;
        int accountHold=0;
        int amount=0;
        int catnum=0;
        int catnum1=0;
        String input=in.nextLine();
        String loopBug;

        in.useDelimiter("\t|,| ");
        switch(input){//switch case checking options
            case ("1")://inflow

            System.out.println("Please input Account# and Amount");
            
            System.out.print("Account:");
            input=in.nextLine();
            accountHold=Integer.parseInt(input);//checks if a valid cod

            System.out.print("\nAmount:");
            Double temp=Double.parseDouble(in.nextLine());
            amount=(int)(temp*CENTS);

            account[accountHold-1].addBalance(amount);
            cat[0][1]=cat[0][1]+amount;
            allMemo=allMemo+"#"+accountHold+"+"+amount+"?input\n";
            //Standard format:OLD+#A+(+/-)+?memo\n
            //Note ACCT IS STORED AS #Input not Array Place
            break;

            
            case ("2")://outflow
            
            System.out.println("Enter Account#, OUTFLOW Amount, Category,and memo");
            

            System.out.print("Account:");
            input=in.nextLine();
            accountHold=Integer.parseInt(input);//checks if a valid cod

            System.out.print("\nAmount:");
            temp=Double.parseDouble(in.nextLine());
            amount=(int)(temp*CENTS);

            System.out.print("Memo: ");//memo add to memo line
            String inputMemo=in.nextLine();
            allMemo=allMemo+"#"+account+"-"+ (amount) + " ?" +inputMemo;
            //Standard format:OLD+#A+(+/-)+?memo\n
            

            System.out.print("Enter the category taken from: ");
            input=in.nextLine();
            catnum=Integer.parseInt(input)-1;
            //System.out.print(catnum);

            
            account[accountHold-1].addBalance(-1*amount);//account #
            
            int math=Integer.parseInt(cat[catnum][1])-amount;
            cat[catnum][1]=String.valueOf(math);//cat#
            
            
            break;

            case ("3")://category transfers

            System.out.print("Enter category to take from:");
            input=in.nextLine();
            catnum=Integer.parseInt(input)-1;
            
            System.out.print("Enter category to add to:");
            input=in.nextLine();
            catnum1=Integer.parseInt(input)-1;
            
            System.out.print("Amount:");
            temp=Double.parseDouble(in.nextLine());
            amount=(int)(temp*CENTS);
            
            math=Integer.parseInt(cat[catnum][1])-amount;
            cat[catnum][1]=""+math;//subtracts first cat
            
            math=Integer.parseInt(cat[catnum1][1])+amount;
            cat[catnum1][1]=""+math;//adds to second cat
            break;

            case ("4")://Automatic inflow distribution
            System.err.println("The developer has no clue how to do this yet,\n pick something else");

            break;

            case ("5")://category
            
            for(i=0;i<cat.length;i++){
                if (cat[i][0]==null){
                    break;
                }
            }
            System.out.print("Please enter the category name: ");
            cat[i][0]=in.nextLine();
            
            cat[i][1]="0";//initializes $
            //add a sizer here cat
            break;
            
            case("6")://account add
            for(i=0;i<account.length;i++){
                if (account[i]==null){
                    break;
                }
            }
            System.out.print("Please enter the account name: ");
            String accountName=in.nextLine();
            System.out.print("Amount: ");
            String hold=in.nextLine();
            amount=(int)(Double.parseDouble(hold)*CENTS);
            
            		
            account[i]=new Account(amount,accountName);
            break;
            
            case ("7")://add a goal
            System.err.println("The developer has no clue how to do this yet,\n pick something else");
            break;

            case ("8")://save
            return allMemo;

            default:
            System.out.println("Please pick a number 1 through 7");

        }
        display(cat,account);

        optionsMenu(account, in, cat,allMemo);
        return allMemo;
    }

    public static void main(String args[])throws IOException, FileNotFoundException{
        Account[] account=new Account[5];
        String allMemo="";
        Scanner in=new Scanner(System.in);
        allMemo=FileRead.readFileMemo("memo.txt");
        FileRead.readFile("account.txt",account);
        String[][] cat=FileRead.readFile("text.txt");
        //files are read in, ready to use

        display(cat, account);
        try {
        optionsMenu(account,in,cat,allMemo);
        
        }catch (Exception e) {
        	System.out.println(e);
        	System.out.println("Saving...");
        	
        }finally {//keeps the data from being lost
        FileWrite.writeToFile(account,"account.txt");
        FileWrite.writeToFile(allMemo,"memo.txt");
        FileWrite.writeToFile(cat,"text.txt");
        }//all saved
        in.close();
    }
}