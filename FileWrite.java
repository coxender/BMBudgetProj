
/**
 * Write a description of class FileWrite here.
 *
 * @Chiara Oxender
 * @v1.30.20
 */
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public class FileWrite
{
    /**
     * @param String[][] the array that stores the budget categories and amounts.
     * @param String  a string version of the text document.
     * @throws NullPointerException when file has no delimiter/ends without delimiter.
     * @return void
     * 
     */
    public static void writeToFile(String[][] cat,String file)throws FileNotFoundException{
        PrintWriter text=new PrintWriter(file);
        for (int i=0; i<cat.length;i++){
            if(cat[i][0]==null){
                break;
            }
            text.printf("#%s #%s",cat[i][0],cat[i][1]);
        }
        text.print("#");//last delimiter
        text.close();
    }
    /**
     * @param String the memos typed into the budget during runtime
     * @param String file location where memos are stored.
     * @return void
     * 
     */
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
        text.print("#");//last
        text.close();
    }
}
