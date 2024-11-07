import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Cypher {

    private static final char[] ALPHABET = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', ' ', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', ':', '!', '?'};

    private static final char[] ALPHABETR = {'?', '!', ':', '"', '»', '«', ',', '.', 'я',
            'ю', 'э', 'ь', 'ы', 'ъ', 'щ', 'ш', 'ч', 'ц', 'х', 'ф', 'у', 'т', 'с', 'р', ' ', 'п', 'о',
            'н', 'м', 'л', 'к', 'й', 'и', 'з', 'ж', 'ё', 'е', 'д', 'г', 'в', 'б', 'а',
            'Я', 'Ю', 'Э', 'Ь', 'Ы', 'Ъ', 'Щ', 'Ш', 'Ч', 'Ц', 'Х', 'Ф', 'У', 'Т', 'С', 'Р', 'П', 'О', 'Н',
            'М', 'Л', 'К', 'Й', 'И', 'З', 'Ж', 'Ё', 'Е', 'Д', 'Г', 'В', 'Б', 'А'};

    static String buf;

    public static void encrypt (String inpAddress, String outAddress, int key, int variation){
        char[] alphabet = ALPHABET;
        if (variation == 1)  alphabet = ALPHABETR;
        StringBuilder str = new StringBuilder();
        try (BufferedReader buffy = Files.newBufferedReader(Paths.get(inpAddress))){
            while ((buf = buffy.readLine()) != null){
                for (char chars: buf.toCharArray()){
                    for (int i = 0; i < alphabet.length; i++){
                        if (chars == alphabet[i]){
                            str.append(alphabet[(i+key)%(alphabet.length)]);
                        }
                    }
                }
                str.append("\n");
            }
            Files.writeString(Paths.get(outAddress), str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bruteForce (String inpAddress, String directory){
        for (int i = 0; i < ALPHABET.length; i++){
            String tempAddress = directory + "\\Brute force result key = " + i + ".txt";
            encrypt(inpAddress, tempAddress, i, 1);
        }
    }
}


