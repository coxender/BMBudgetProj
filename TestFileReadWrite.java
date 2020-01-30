
/**
 * Write a description of class TestFileReadWrite here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.IOException;
public class TestFileReadWrite
{
    public static void main(String[] args)throws IOException{
        String[][] file=FileRead.readFile("text.txt");
        
        for (int j=0;j<file.length;j++){
                System.out.printf("\n%10s $%5s",file[j][0],(file[j][1]));
        
            }
        FileWrite.writeToFile(file,"text.txt");
}
}
