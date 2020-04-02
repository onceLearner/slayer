// TODO: 02/04/2020 create fucntions to compaire two files
package UsefulFunctions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Functions {

    public static int CompareFile(File file1,File file2) throws FileNotFoundException {
        String line;
//        if(file1.length()!=file2.length()) return 1 ;
        Scanner scan_file1=new Scanner(file1);
        Scanner scan_file2=new Scanner(file2);
        while (scan_file1.nextLine()!=null) {
            line=scan_file1.nextLine().toString();
            if(scan_file2.nextLine().toString().equals(line) ) return 2;

        }
        return 3;



    }
    public static int isEqual(Path firstFile, Path secondFile) {
        try {
            long size = Files.size(firstFile);
            if (size != Files.size(secondFile)) {
                return 1;
            }

            if (size < 2048) {
                return Arrays.equals(Files.readAllBytes(firstFile),
                        Files.readAllBytes(secondFile))?2:3;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 6;

    }


}
