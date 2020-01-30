
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
    final private  int TO_CENTS=100;
    final private double TO_DOLLARS=1/100.0;
    public FileRead(String accountName,String file) throws IOException, FileNotFoundException{
        //intialize Scanners and Files

        File text= new File(file);//File with budget
        Scanner readFile= new Scanner(file);
        Scanner in= new Scanner(System.in);

        //variables
        String[][] categoryCents= new String[10][2];
        
        

        
        
        //get categories and scores 
        System.out.println("\nHere is your budget:");
        for(int i=0;i<category.length;i++){
            if(!readFile.hasNext())
                break;
            readFile.useDelimiter("#");
            categoryCents[i][0]=readFile.next();//gets name

            readFile.useDelimiter("#");
            categoryCents[i][1]=readFile.next();//gets amount
            
            System.out.printf("\t[%d] %s\n\t\t$%.2f\n",i+1,categoryCents[i][0],categoryCents[i][1]*TO_DOLLARS);

            if(!readFile.hasNext()){

                break;
            }

        }
    }
    public void readFileMemo(String file){
        File text=new File(file);
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
    }
}
