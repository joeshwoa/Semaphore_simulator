import java.io.FileWriter;
import java.io.IOException;
public class WriteToFile {
    private FileWriter file_writer;
    WriteToFile (String name)
    {
        String s = "D:\\" + name;
        try {
            file_writer = new FileWriter(s);
            System.out.println("Successfully creation writer.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void Write (String target)
    {
        try {
            file_writer.write(target + " ");
            System.out.println("Successfully wrote "+target+" in the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void Close ()
    {
        try {
            file_writer.close();
            System.out.println("Successfully close file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
