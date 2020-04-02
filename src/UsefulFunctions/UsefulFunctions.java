// TODO: 02/04/2020 create fucntions to compaire two files
package UsefulFunctions;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class UsefulFunctions {

    public static boolean CompareFile(Path p1,Path  p2) throws IOException {

        byte[] file1_content = Files.readAllBytes(p1);
        byte[] file2_content  = Files.readAllBytes(p2);
        return Arrays.equals(file1_content,file1_content);

    }


}
