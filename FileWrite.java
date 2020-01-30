
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
    public void writeToFile(String[] cat,int[] value,String file)throws FileNotFoundException{
        PrintWriter text=new PrintWriter(file);
        for (int i=0; i<cat.length;i++){
            if(cat[i]==null){
                break;
            }
            text.printf("#%s #%d",cat[i],value[i]/100);
        }
        text.close();
    }
    public void writeToFile(String allMemo, String file)throws FileNotFoundException{
        PrintWriter text=new PrintWriter(file);
        text.println(allMemo);
        text.close();
       
    }
}
