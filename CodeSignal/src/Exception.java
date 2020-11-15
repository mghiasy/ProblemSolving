import java.io.*;
public class Exception {
    public static void main(String[] args) throws IOException {
        System.out.println("111111");
        FileReader file = new FileReader("");
        BufferedReader fileInput = new BufferedReader(file);

        // Print first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++)
            System.out.println(fileInput.readLine());

        fileInput.close();
    }
}
