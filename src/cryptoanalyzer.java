import java.util.Scanner;



public class cryptoanalyzer {

    public static void main(String[] args) {

        System.out.println("Choose action:");
        System.out.println("1 - encrypt");
        System.out.println("2 - decrypt");
        System.out.println("3 - bruteforce");
        System.out.println("9 - EXIT");
        System.out.println("*-----------------*");

        Scanner scanner = new Scanner(System.in);
        String inputAddress;
        String outputAddress;
        Integer key;

        Integer action;
        action = Integer.parseInt(scanner.nextLine());

        switch (action){
            case 1:
                System.out.println("Enter input file location");
                inputAddress = scanner.nextLine();
                if (Encrypt.fileChek(inputAddress)){
                    System.out.println("Enter output file location");
                    outputAddress = scanner.nextLine();
                    if (Encrypt.fileChek(outputAddress)){
                        System.out.println("Enter a cypher key between -100 and 100");
                        key = Integer.parseInt(scanner.nextLine());
                        if (Encrypt.keyChek(key)){
                            Encrypt.encrypt(inputAddress, outputAddress, key);
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Enter input file location");
                inputAddress = scanner.nextLine();
                if (Decrypt.fileChek(inputAddress)){
                    System.out.println("Enter output file location");
                    outputAddress = scanner.nextLine();
                    if (Decrypt.fileChek(outputAddress)){
                        System.out.println("Enter a cypher key between -100 and 100");
                        key = Integer.parseInt(scanner.nextLine());
                        if (Decrypt.keyChek(key)){
                            Decrypt.decrypt(inputAddress, outputAddress, key);
                        }
                    }
                }
                break;
            default:
                System.out.println("See ya!");

        }

    }
}
