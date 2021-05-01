

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;


/**
 * The test class FileWriteTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FileWriteTest
{
    

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    
    public static void Write()throws FileNotFoundException{
      ;
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void write() throws FileNotFoundException
    {  
        Account[] a= new Account[5];
        String memo="bleb";
        String[][] cat=new String[5][2];
        FileWrite.writeToFile(a,"account.txt");
        FileWrite.writeToFile(memo,"memo.txt");
        FileWrite.writeToFile(cat,"text.txt");
    }
}

