/**
 * Write a description of class FileWrite here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class FileRead{
    final private static  int TO_CENTS=100;
    final private static double TO_DOLLARS=1/100.0;
    private static Scanner makeFile(String file){//File Exception catching method
        
     try{
         File text= new File(file);
         text.setReadable(true);
         Scanner in=new Scanner(text);
         return(in);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            
            System.exit(1);
        }catch(IOException e){
            System.out.println(e.getMessage());
            System.exit(1);   
         
        }  
        return(null);
    }
   
    public static String[][] readFile(String file) {
         
         String[][] categoryCents= new String[10][2];
         Scanner readFile=makeFile(file);//Exception catcher
        
         //initialize variables

         for(int i=0;i<categoryCents.length;i++){
            
            readFile.useDelimiter("#");
            if(!readFile.hasNext()){
                break;}
            categoryCents[i][0]=readFile.next();//gets name
            
            System.out.print(categoryCents[i][0]);
            
            readFile.useDelimiter("#");
            if(!readFile.hasNext()){
                categoryCents[i][1]="0";//initialize any hanging data
                break;}
            categoryCents[i][1]=readFile.next();//gets amount AS A STRING
            
            System.out.print(categoryCents[i][1]);
            
            // TEST System.out.printf("\t[%d] %s\n\t\t$%.2f\n",i+1,categoryCents[i][0],Integer.parseInt(categoryCents[i][1])*TO_DOLLARS);
            
             
            
            
            if (i==categoryCents.length&&readFile.hasNext()){
                //resize array
            }

            
        }
        return categoryCents;
    }

    public static Account[] readFile(String file, Account[] account){
        Scanner read=makeFile(file);
        String accountName;
        int balanceCents=0;
        read.useDelimiter("#");
        for(int i=0;i<account.length;i++){
            if(!read.hasNext())
                break;
            accountName=read.next();

            read.useDelimiter("#");
            balanceCents=read.nextInt();

            account[i]=new Account(balanceCents,accountName);
            read.useDelimiter("#");
            
            
            if (i==account.length&&read.hasNext()){
                //resize array
            }       
        }
        return account;
    }

    public static String readFileMemo(String file){
        Scanner readMem=makeFile(file);
        

        String allMemo="";

        while(true){//memo
            String line=readMem.nextLine();
            allMemo=allMemo+line+"\n";
            if(!readMem.hasNext()){
                allMemo=allMemo+" ";
                break;
            }

        }
        return allMemo;
    }
}

