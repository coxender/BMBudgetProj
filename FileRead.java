
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
    private static File makeFile(String file){//File Exception catching method
        
     try{
        File text= new File(file);
        
        
        }catch(FileNotFoundException e){
            System.out.println(getMessage());
            System.out.println(stackTrace());
            System.exit();
        }catch(IOException e){
            System.out.println(getMessage());
            System.out.println(stackTrace());
            System.exit();   
         
        }  
        return(text);
    }
    public static String[][] readFile(String file) throws IOException, FileNotFoundException{
         
         String[][] categoryCents= new String[10][2];
         File text=makeFile(file);//Exception catcher
        Scanner readFile= new Scanner(text);
         //initialize variables

        for(int i=0;i<categoryCents.length;i++){
            if(!readFile.hasNext())
                break;
            readFile.useDelimiter("#");
            categoryCents[i][0]=readFile.next();//gets name
            
            System.out.print(categoryCents[i][0]);
            
            readFile.useDelimiter("#");
            categoryCents[i][1]=readFile.next();//gets amount AS A STRING
            
            System.out.print(categoryCents[i][1]);
            
            System.out.printf("\t[%d] %s\n\t\t$%.2f\n",i+1,categoryCents[i][0],Integer.parseInt(categoryCents[i][1])*TO_DOLLARS);
            
             
            
            if(!readFile.hasNext())
                break;
            if (i==categoryCents.length&&readFile.hasNext()){
                //resize array
            }

            
        }
        return categoryCents;
    }

    public static void readFile(String file, Account[] account)throws IOException, FileNotFoundException{
        File text=makeFile(file);
        Scanner read=new Scanner(text);
        String accountName;
        int balanceCents=0;
        read.useDelimiter("#");
        for(int i=0;i<account.length;i++){
            
            accountName=read.next();

            read.useDelimiter("#");
            balanceCents=read.nextInt();

            account[i]=new Account(balanceCents,accountName);
            read.useDelimiter("#");
            
            if(!read.hasNext())
                break;
            if (i==account.length&&read.hasNext()){
                //resize array
            }       
        }
    }

    public static String readFileMemo(String file)throws IOException, FileNotFoundException{
        File text=makeFile(file);
        Scanner readMem=new Scanner(text);

        String allMemo="";

        while(true){//memo
            String line=readMem.nextLine();
            allMemo=allMemo+line;
            if(!readMem.hasNext()){
                allMemo=allMemo+" ";
                break;
            }

        }
        return allMemo;
    }
}
