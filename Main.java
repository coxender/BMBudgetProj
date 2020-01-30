 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
//THERE IS AN ISSUE WITH CENTS, CHECK TYPE CASTS
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
     */
    public static void display(String[] cat, int[] cents){
        for(int i=0;i<cat.length;i++){
            if(cat[i]==null){
                break;
            }
            System.out.printf("\t [%d]%s\n\t\t$%.2f.\n",i+1,cat[i],cents[i]/100.0);
            
        }
    }

    public static void catcher(Scanner in){
        while(!in.hasNextDouble()){
            String trash=in.nextLine();
            
        }
    }

    public static String optionsMenu(Scanner in, String[] cat, int[] val,String allMemo){
            
        final String OPTIONS=String.format("Possible Actions:\n"+
                "[1] INFLOW\n"+
                "[2] OUTFLOW\n"+
                "[3] TRANSFER BETWEEN CATEGORY\n"+
                "[4] SET UP AUTOMATIC INFLOW DIST*\n"+
                "[5] ADD  A NEW CATEGORY\n"+
                "[6] ADD A GOAL*\n"+
                "[7] SAVE AND EXIT\n\n"+

                "Enter Action Number: ");
                
        System.out.println(OPTIONS);
        catcher(in);
        String input=in.nextLine();
        switch(input){
            case ("1")://inflow

            System.out.print("Enter INFLOW Amount: ");
            catcher(in);
            int inflow=100*(int)in.nextDouble();
            
            System.out.print("Memo: ");//memo add to memo line
            in.nextLine();
            String inputMemo=in.nextLine();
            
            allMemo=allMemo+"\n +"+ (inflow/100) + " " +inputMemo;

            System.out.print("Enter the category added to: ");
            catcher(in);
            int catNumber=in.nextInt()-1;
            val[catNumber]=val[catNumber]+inflow;
            
            break;

            case ("2")://outflow
            System.out.print("Enter OUTFLOW Amount: ");
            catcher(in);
            int outflow=100*(int)in.nextDouble();
            in.nextLine();
            
            System.out.print("Memo: ");//memo add to memo line

            inputMemo=in.nextLine();
            allMemo=allMemo+" \n -"+ (outflow/100) + " " +inputMemo;
               
            System.out.print("Enter the category added to: ");
            catcher(in);
            catNumber=in.nextInt()-1;
            val[catNumber]=val[catNumber]-outflow;
            
            break;

            case ("3"):
            
            System.out.print("Enter the category to take from: ");
            catcher(in);
            int catNumber1=in.nextInt()-1;//get 1st cat

            System.out.print("Enter the category to give to: ");
            catcher(in);
            int catNumber2=in.nextInt()-1;//get second cat

            System.out.print("Enter amount to transfer: ");
            catcher(in);
            double transfer=100*in.nextDouble();
            val[catNumber1]=val[catNumber1]-(int)transfer;
            val[catNumber2]=val[catNumber2]+(int)transfer;
            in.nextLine();
            break;

            case ("4")://yeahhhh whoops
            System.err.println("The developer has no clue how to do this yet,\n pick something else");
            
            break;

            case ("5"):
            int i;
            for(i=0;i<cat.length;i++){
                if (cat[i]==null){
                    break;
                }
            }
            System.out.print("Please enter the category name: ");
            cat[i]=in.nextLine();  

            
            break;

            case ("6"):
            System.err.println("The developer has no clue how to do this yet,\n pick something else");
            break;

            case ("7"):
            return allMemo;
            
            
            default:
            System.out.println("Please pick a number 1 through 7");

        }
        display(cat, val);
        
        
        optionsMenu(in, cat, val,allMemo);
        return allMemo;
    }

    public static void writeToFile(String[] cat,int[] value,String allMemo)throws FileNotFoundException{
        PrintWriter text=new PrintWriter("text.txt");
        PrintWriter memo=new PrintWriter("memo.txt");
        for (int i=0; i<cat.length;i++){
            if(cat[i]==null){
                break;
            }
            text.printf("#%s #%d",cat[i],value[i]/100);
        }
        text.close();
        memo.println(allMemo);
        memo.close();
    }

    public static void main(String args[])throws IOException, FileNotFoundException{
        //intialize Scanners and Files
        
        File file= new File("text.txt");//File with budget
        File memFile= new File("memo.txt");//memo
        Scanner readFile= new Scanner(file);
        Scanner readMem= new Scanner(memFile);
        Scanner in= new Scanner(System.in);

        //variables
        String[] category= new String[10];
        String allMemo="";
        int[] cents= new int[category.length];
        int inflow;
        int outflow;
        final int TO_CENTS=100;
        final double TO_DOLLARS=1/100.0;
        
        while(true){//memo
            String line=readMem.nextLine();
            allMemo=allMemo+line;
            if(!readMem.hasNext()){
                allMemo=allMemo+" ";
                break;
            }
        }
        //get categories and scores 
        System.out.println("\nHere is your budget:");
        for(int i=0;i<category.length;i++){
            if(!readFile.hasNext())
                break;
	    readFile.useDelimiter("#");
            category[i]=readFile.next();

            
            readFile.useDelimiter("#");
            String input=readFile.next();
            
            cents[i]=TO_CENTS*Integer.valueOf(input);//makes txt usable

            System.out.printf("\t[%d] %s\n\t\t$%.2f\n",i+1,category[i],cents[i]*TO_DOLLARS);

            if(!readFile.hasNext()){
                
                break;
            }

        }
        
        
        
        //option menu
        allMemo=optionsMenu(in, category, cents,allMemo);
        writeToFile(category,cents,allMemo);
        
    }

}
