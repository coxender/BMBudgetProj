/**
 * Write a description of class FileWrite here.
 *
 * @Chiara Oxender
 * @v1.30.20
 */

import java.io.*;
public class FileWrite
{
    /**
     * @param String[][] the array that stores the budget categories and amounts.
     * @param String  a string version of the text document.
     * @throws NullPointerException when file has no delimiter/ends without delimiter.
     * @return void
     * 
     */
    
    private static PrintWriter makeWriter(boolean append,File use){
        PrintWriter text=null;
        File backup=new File("backup.txt");
        try{
            
            use.setWritable(true);

            FileOutputStream stream= new FileOutputStream(use, append);
            text=new PrintWriter(stream);

            return(text);
        }catch(FileNotFoundException e){
            System.out.print(e.getMessage());
            System.out.print("File not Found.\nCreating Backup File...");
            //create new file
            try{
                backup=new File("backup.txt");
                System.out.print(backup.createNewFile());
                FileOutputStream streamBack= new FileOutputStream(backup,true);//appends so multiple can be written to 
                
                text=new PrintWriter(streamBack);
                
            }catch(IOException e1){
                
                e1.getMessage();
                e1.getStackTrace();
                System.out.print("Error: Data may not have been saved");
            }

        }catch (Exception e){
            e.getStackTrace();
            System.out.print("unexpected exception occurred");

            System.exit(-1);
        }

        return(null);
    }

    public static void writeToFile(String[][] cat,String file){
        File use=new File(file);
        PrintWriter text=makeWriter(false,use);
        for (int i=0; i<cat.length;i++){
            if(cat[i][0]==null){
                break;
            }
            text.printf("#%s #%s",cat[i][0],cat[i][1]);
        }
        text.print("#");//last delimiter
        text.close();
        use.setReadOnly();
    }

    /**
     * @param String the memos typed into the budget during runtime
     * @param String file location where memos are stored.
     * @return void
     * 
     */
    public static void writeToFile(String allMemo, String file)throws FileNotFoundException{
        File use=new File(file);
        PrintWriter text=makeWriter(true,use);
        text.println(allMemo);
        text.close();
        use.setReadOnly();

    }

    public static void writeToFile(Account account[],String file)throws FileNotFoundException{
        File use=new File(file);
        PrintWriter text=makeWriter(false,use);

        /*try{
        FileOutputStream stream= new FileOutputStream(file,true);//initializing
        text=new PrintWriter(stream);
        }catch(FileNotFoundException e){
        e.getMessage();
        text=makeWriter(file);
        }*/

        //if FileNotFound, should use other method.
        //May be issue with lost data, if goes to makeWriter, only
        //new memos will be written over.
        //Sol: set numeric marker if only new material so saves directly
        //to a backup and saves the old data from being over written
        //>>better Sol: Have printMaker require a boolean to append, then
        //route all to printMaker

        for (int i=0; i<account.length;i++){
            if(account[i]==null){
                break;
            }
            text.printf("#%s #%d",account[i].accountName,account[i].getBalance()/100);
        }
        text.print("#");//last
        text.close();
        use.setReadOnly();
    }
}