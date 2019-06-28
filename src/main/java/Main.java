import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        InputStream inputStream = Main.class.getResourceAsStream("/file.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while((line= reader.readLine()) != null) {
            System.out.println(line);
        }
        MyMath mm = new MyMath();
        System.out.println(mm.add(4,9));
    }
}
