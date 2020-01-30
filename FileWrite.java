
/**
 * Write a description of class FileWrite here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public class FileWrite
{
    public static void writeToFile(String[][] cat,String file)throws FileNotFoundException{
        PrintWriter text=new PrintWriter(file);
        for (int i=0; i<cat.length;i++){
            if(cat[i]==null){
                break;
            }
            text.printf("#%s #%s",cat[i][0],cat[i][1]);
        }
        text.close();
    }
    public static void writeToFile(String allMemo, String file)throws FileNotFoundException{
        PrintWriter text=new PrintWriter(file);
        text.println(allMemo);
        text.close();
       
    }
    public static void writeToFile(Account account[],String file)throws FileNotFoundException{
        PrintWriter text=new PrintWriter(file);
        for (int i=0; i<account.length;i++){
            if(account[i]==null){
                break;
            }
            text.printf("#%s #%d",account[i].accountName,account[i].getBalance()/100);
        }
        text.close();
    }
}
