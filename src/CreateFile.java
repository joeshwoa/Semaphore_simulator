import java.io.File;
import java.io.IOException;
public class CreateFile {
    CreateFile (String name)
    {
        String s = "D:\\OS_assignment_1\\" + name;
        try {
            File myObj = new File(s);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}