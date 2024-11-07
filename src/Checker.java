import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Checker {

    static Scanner scanner = new Scanner(System.in);

    public static boolean fileCheck (String directory){
        try {
            if (Files.isRegularFile(Paths.get(directory))){
                return true;
            }
            else {
                System.out.println("Файл не найден.");
                System.out.println("Пожалуйста, вводите корректный путь к существующему .txt файлу.");
                System.out.println();
                return false;
            }
        }
        catch (InvalidPathException e){
            System.out.println("Файл ненайденЪ.");
            System.out.println("Пожалуйста, вводите корректный путь к существующему .txt файлу.");
            System.out.println();
            return false;
        }
    }

    public static boolean directoryCheck (String directory){
        Path pth = Paths.get(directory);
        if (pth.isAbsolute()){
            return true;
        }
        else{
            System.out.println("Указанная директория не действительна.");
            System.out.println("Пожалуйста, вводите полный корректный путь.");
            return  false;
        }

    }

    public static int optionCheck (){
        int option = 9;
        try{
            option = scanner.nextInt();
            if(option != 1 && option != 2 && option != 3 && option != 9){
                System.out.println("Пожалуйста, вводите с клавиатуры цифру из меню.");
                return 9;
            }
            else return option;
        }
        catch (Exception e){
            System.out.println("Пожалуйста, вводите с клавиатуры цифру из меню.");
            return option;
        }


    }

}
