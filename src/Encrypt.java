import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Encrypt {



    static String buf;
    static StringBuilder str = new StringBuilder();

    public static boolean fileChek (String address){
        if (Files.notExists(Paths.get(address))){
            System.out.println("File not found.");
            return false;
        }
        else return true;
    }

    public static boolean keyChek (Integer key){

        if (Math.abs(key) > 100){
            System.out.println("Incorrect key");
            return false;
        }
        else return true;

    }

    public static void encrypt (String inpAddress, String outAddress, Integer key){

        try (BufferedReader buffy = Files.newBufferedReader(Paths.get(inpAddress))){
            while ((buf = buffy.readLine()) != null){
                for (char chars: buf.toCharArray()){
                    str.append((char)(chars+key));
                }
                str.append("\n");
            }
            Files.writeString(Paths.get(outAddress), str);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }
}


