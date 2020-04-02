
import java.io.*;
import java.nio.file.Files;;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import UsefulFunctions.Functions;

public class VersionOne {
    public static void main(String[] args) throws Exception {
        String command1 = "cmd /c cd C:\\Users\\OnceLearner\\Music\\program && gcc -o scanProgram file1.c && scanProgram ";
        String command2 = "cmd /c time";

        Process proc = Runtime.getRuntime().exec(command1);   // create a process

        //create file to read input from it
        File In_file=new File("C:\\Users\\OnceLearner\\Music\\program\\In_file","in_file1.txt");
        Scanner fileScanner=new Scanner(In_file);
        String f_conent=fileScanner.nextLine();
        boolean f_canread=In_file.canRead();  // check if the file is readable



        // create file to pass output to it
        File Out_file= new File("C:\\Users\\OnceLearner\\Music\\program\\Out_file","out_file.txt");
        boolean flag=Out_file.createNewFile();
        FileWriter fwrite=new FileWriter(Out_file);


        // create or retrieve file to Compare
        File compare_file=new File("C:\\Users\\OnceLearner\\Music\\program\\Compare_out","compare.txt");


        // create a channel to pass argument through the OutputStream class
        OutputStream out = proc.getOutputStream();
        PrintWriter writer = new PrintWriter(out);



        writer.write(f_conent); //'\n' to simulate enter key or we can run it without it
        writer.close(); // You are my everything !! Darori close the writer

        // Retrieve output from the program ( cadire from cmd )

        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {


            fwrite.write(line);
            fwrite.close();
        }

          // compare the two files : the standaard output and the user output
        Path p1=Paths.get("C:\\Users\\OnceLearner\\Music\\program\\Compare_file\\compare.txt");
        Path p2=Paths.get("C:\\Users\\OnceLearner\\Music\\program\\Out_file\\out_file.txt");

        byte[] f1 = Files.readAllBytes(p1);
        byte[] f2 = Files.readAllBytes(p2);
        boolean result=Arrays.equals(f1,f2);
          if (result)  System.out.println("                                                        your Algorithm  Works Fine  !" );
          else
              System.out.println("your Solution is not Working !" );


    }



}