import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class VersionOne {
    public static void main(String[] args) throws Exception {
        String command1 = "cmd /c cd C:\\Users\\OnceLearner\\Music\\program && gcc -o scanProgram file1.c && scanProgram ";
        String command2 = "cmd /c time";

        Process proc = Runtime.getRuntime().exec(command1);   // create a process

        // create a channel to pass argument through the OutputStream class
        OutputStream out = proc.getOutputStream();
        PrintWriter writer = new PrintWriter(out);


        writer.write("4\n"); //'\n' to simulate enter key or we can run it without it
        writer.close(); // You are my everything !! Darori close the writer

        // Retrieve output from the program ( cadire from cmd )
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}