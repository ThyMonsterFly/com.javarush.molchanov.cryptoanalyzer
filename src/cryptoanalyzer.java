import java.util.Scanner;

public class cryptoanalyzer {

    public static void main(String[] args) {

        String inputAddress;
        String outputAddress;
        String bruteForceDirectory;
        int key = 0;
        int action;
        boolean running = true;
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Привет!");
        System.out.println("Это - программа для шифрования текстовых файлов шифром Цезаря.");
        System.out.println("ВНИМАНИЕ - Данная программа работает только с файлами формата .txt, содержащими буквы Русского алфавита.");
        System.out.println("*--------------------------------------------------------------*");

        do {

            System.out.println("Введите 1, чтобы зашифровать файл известным ключом.");
            System.out.println("Введите 2, чтобы расшифровать файл с известным ключом.");
            System.out.println("Введите 3, чтобы применить метод Brute Force к файлу (Цезарь не одобряет \uD83D\uDE09).");
            System.out.println("Введите 9, чтобы выйти из программы.");
            System.out.print("Пожалуйста, введите номер желаемого действия:");
            action = Checker.optionCheck();

            switch (action){
                case 1:
                    System.out.print("Введите путь к исходному файлу: ");
                    inputAddress = scan.nextLine();
                    if (Checker.fileCheck(inputAddress)){
                        System.out.print("Введите путь к файлу с результатом ширования: ");
                        outputAddress = scan.nextLine();
                        if (Checker.fileCheck(outputAddress)){
                            System.out.print("Введите целое число для задания ключа: ");
                            try{
                                key = Integer.parseInt(scan.nextLine());
                            }
                            catch (NumberFormatException e){
                                System.out.println("Введён некорректный ключ.");
                                System.out.println();
                                break;
                            }
                            Cypher.encrypt(inputAddress, outputAddress, Math.abs(key), 0);
                            System.out.println("Шифрование успешно завершено.");
                            System.out.println();
                        }
                        else break;
                    }
                    else break;
                    break;
                case 2:
                    System.out.print("Введите путь к исходному файлу: ");
                    inputAddress = scan.nextLine();
                    if (Checker.fileCheck(inputAddress)){
                        System.out.print("Введите путь к файлу с результатом деширования: ");
                        outputAddress = scan.nextLine();
                        if (Checker.fileCheck(outputAddress)){
                            System.out.print("Введите целое число для задания ключа: ");
                            try{
                                key = Integer.parseInt(scan.nextLine());
                            }
                            catch (NumberFormatException e){
                                System.out.println("Введён некорректный ключ.");
                                System.out.println();
                                break;
                            }
                            Cypher.encrypt(inputAddress, outputAddress, Math.abs(key), 1);
                            System.out.println("Дешифрование успешно завершено.");
                            System.out.println();
                        }
                        else break;
                    }
                    else break;
                    break;
                case 3:
                    System.out.print("Введите путь к исходному файлу: ");
                    inputAddress = scan.nextLine();
                    if (Checker.fileCheck(inputAddress)){
                        System.out.print("Введите путь к директории, в которой будут сложены результаты работы метода: ");
                        bruteForceDirectory = scan.nextLine();
                        if (Checker.directoryCheck(bruteForceDirectory)){
                            Cypher.bruteForce(inputAddress, bruteForceDirectory);
                            System.out.println("Метод успешно применён.");
                            System.out.println();
                        }
                        else break;
                    }
                    else break;
                    break;
                case 9: running = false;
                default:
                    System.out.println("Хорошего дня \uD83D\uDE0A");
                    System.out.println("Увидимся!");

            }

        } while (running);

    }

}

