
import java.io.*;
;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import UsefulFunctions.UsefulFunctions;

public class VersionOne {
    public static void main(String[] args) throws Exception {

        //paths to the 3 files : input file , user outputted file and compare file
        Path Path_to_input_file=Paths.get("C:\\Users\\OnceLearner\\Music\\program\\In_file\\in_file1.txt");
        Path Path_to_ouput_file=Paths.get("C:\\Users\\OnceLearner\\Music\\program\\Out_file\\out_file.txt");
        Path Path_to_compare_file=Paths.get("C:\\Users\\OnceLearner\\Music\\program\\Compare_file\\compare.txt");


        // commands to compile and run+ intialize the process the process
        String command1 = "cmd /c cd C:\\Users\\OnceLearner\\Music\\program && gcc -o scanProgram file1.c && scanProgram ";
        String command2 = "cmd /c time";

        Process proc = Runtime.getRuntime().exec(command1);   // create a process


        //create file to read input from it
        File In_file=new File(Path_to_input_file.toString());
        Scanner fileScanner=new Scanner(In_file);
        String input_file_conent=fileScanner.nextLine();
        boolean f_canread=In_file.canRead();  // check if the file is readable



        // create file to pass User output to it
        File Out_file= new File( Path_to_ouput_file.toString()); // toString because the argument is string not a path object
        boolean flag=Out_file.createNewFile();
        FileWriter fwrite=new FileWriter(Out_file);


        // create or retrieve file to Compare
        File compare_file=new File(Path_to_compare_file.toString());


        // create a channel to pass argument through the OutputStream class
        OutputStream out = proc.getOutputStream();
        PrintWriter writer = new PrintWriter(out);


        // passing arguments to the the requester ie the cmd from the input file
        writer.write(input_file_conent);               //'\n' to simulate enter key or we can run it without it
        writer.close();                               // You are my everything !! Darori close the writer


        // Retrieve output from the program ( cadire from cmd )
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            fwrite.write(line);
            fwrite.close();
        }


        // compare the two files : the standaard output and the user output
        boolean result= UsefulFunctions.CompareFile(Path_to_compare_file,Path_to_ouput_file);
        if (result)  System.out.println("                                                        your Algorithm  Works Fine  !" );
          else
              System.out.println("your Solution is not Working !" );


    }



}
// TODO: 02/04/2020  create path variable  : dne
// TODO: 02/04/2020  create functions for almost everythihng : half done