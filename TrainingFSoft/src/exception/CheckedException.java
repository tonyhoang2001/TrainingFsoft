package exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException {
    public static void main(String[] args)
            throws IOException
    {
//        try {
            // Reading file from path in local directory
            FileReader file = new FileReader("D:\\testCheckedExc.txt");

            // Creating object as one of ways of taking input
            BufferedReader fileInput = new BufferedReader(file);

            // Printing first 3 lines of file "C:\test\a.txt"
            for (int counter = 0; counter < 3; counter++){
                System.out.println(fileInput.readLine());
            }

            // Closing file connections
            // using close() method
            fileInput.close();
//        }catch (IOException e){
//            System.err.println(e.getMessage());
//        }

    }
}
