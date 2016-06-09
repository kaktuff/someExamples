package someExamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by poskotinova-ls on 03.06.2016.
 * объект для работы с консолью
 */
public class Console {
    final static Scanner scannerIn = new Scanner(System.in);

    /**
     * метод для считывния с консоли некоего признака - число, in (0, 1)
     * реализация через переменную, которая хранит инф о том, что признак считан
     * */
    // TO_DO: нужно ли оборачивать в NullPointer весь функционал, который вызывает эту функцию, из-за того, что она может вернуть null
    public int readMarkVar(){
        // обработчика на пустое значение нет, т.к. подобная реализация не считает пустую строку
        int     isRead = 0;//этот признак показывает, что мы действительно считали признак(числе, in (0, 1)) с консоли
        Integer mark = null;
        String  readOurSout;

        Scanner scannerIn = new Scanner(System.in);
        while (isRead == 0){
            try{
                mark = scannerIn.nextInt();
                while (mark != 1 & mark != 0) {
                    System.out.println("Вы ввели недопустимое значение. Введите одно из допустимых Y/N");
                    readOurSout = scannerIn.nextLine();
                    mark = scannerIn.nextInt();
                }
                isRead = 1;
            }catch(java.util.InputMismatchException exInMismatch){
                System.out.println("Вы ввели символы не являющиеся числом. Попробуйте ещё раз");
                readOurSout = scannerIn.nextLine();
            }
        }

        return mark;
    }

    /**
     * метод для считывния с консоли некоего признака - число, in (0, 1)
     * реализация БЕЗ переменной, которая хранит инф о том, что признак считан
     * */
    // TO_DO: нужно ли оборачивать в NullPointer весь функционал, который вызывает эту функцию, из-за того, что она может вернуть null
    public int readMark(){
        // обработчика на пустое значение нет, т.к. подобная реализация не считает пустую строку
        Integer mark = null;
        String  readOurSout;

        while (true){
            try{
                mark = scannerIn.nextInt();
                while ((mark != 1 & mark != 0)/*|(mark == null)*/) {
                    System.out.println("Вы ввели недопустимое значение. Введите одно из допустимых Y/N");
                    readOurSout = scannerIn.nextLine();
                    mark = scannerIn.nextInt();
                }
                break;
            }catch(java.util.InputMismatchException exInMismatch){
                System.out.println("Вы ввели символы не являющиеся числом. Попробуйте ещё раз");
                readOurSout = scannerIn.nextLine();
            }
        }

        return mark;
    }

    /**
     * метод для считывния с консоли типа сортировки
     * реализация через переменную, которая хранит инф о том, что данные корректно считаны
     * */
    // TO_DO: как вариант - этот метод должен быть в классе SortType
    // TO_DO: нужно ли оборачивать в NullPointer весь функционал, который вызывает эту функцию, из-за того, что она может вернуть null
    public SortType readSortTypeVar(){
        int isCorrectSortType = 0;
        String  readOurSout;
        SortType readedSortType = null;

        // Arrays.toString(SortType.values()) - получает все объекты enumа
        System.out.println("Выберите тип сортировки, допустимые значения: " + Arrays.toString(SortType.values()));
        String stringReadedSortType = scannerIn.nextLine();// строка считанная с консоли

        // проверим корректность вводимых данных
        while (isCorrectSortType == 0) {
            try {
                readedSortType = SortType.valueOf(stringReadedSortType); //считанное значение из консоли пытаемся преобразовать к типу SortType
                isCorrectSortType = 1;
            }
            // ошибка возникает, если ввели значение, которго нет в Enum типе
            catch (IllegalArgumentException illegalArgEx){
                System.out.println("Вы ввели недопустимое значение для Типа сортировки. Посмотрите допустимые значения и попробуйте ещё раз:");
                //System.out.println("stringReadedSortType - " + stringReadedSortType);
                stringReadedSortType = scannerIn.nextLine();// строка считанная с консоли
            }
            // это ошибка возникает, если при проверке нахождения строки как значения Enum передано null значение
            catch (NullPointerException nullPointEx){
                System.out.println("Вы не ввели никакого значения. Выберите пожалуйста из списка:");
                readOurSout = scannerIn.nextLine();
            }
        }
        return readedSortType;
    }

    /**
     * метод для считывния с консоли типа сортировки
     * реализация БЕЗ переменной, которая хранит инф о том, что данные корректно считаны
     * */

    // TO_DO: как вариант - этот метод должен быть в классе SortType
    // TO_DO: нужно ли оборачивать в NullPointer весь функционал, который вызывает эту функцию, из-за того, что она может вернуть null
    public SortType readSortType(){
        String  readOurSout;
        SortType readedSortType = null;

        // Arrays.toString(SortType.values()) - получает все объекты enumа
        System.out.println("Выберите тип сортировки, допустимые значения: " + Arrays.toString(SortType.values()));
        String stringReadedSortType = scannerIn.nextLine();// строка считанная с консоли

        // проверим корректность вводимых данных
        while (true) {
            try {
                readedSortType = SortType.valueOf(stringReadedSortType); //считанное значение из консоли пытаемся преобразовать к типу SortType
                break;
            }
            // ошибка возникает, если ввели значение, которго нет в Enum типе
            catch (IllegalArgumentException illegalArgEx){
                System.out.println("Вы ввели недопустимое значение для Типа сортировки. Посмотрите допустимые значения и попробуйте ещё раз:");
                //System.out.println("stringReadedSortType - " + stringReadedSortType);
                stringReadedSortType = scannerIn.nextLine();// строка считанная с консоли
            }
            // это ошибка возникает, если при проверке нахождения строки как значения Enum передано null значение
            catch (NullPointerException nullPointEx){
                System.out.println("Вы не ввели никакого значения. Выберите пожалуйста из списка:");
                readOurSout = scannerIn.nextLine();
            }
        }
        return readedSortType;
    }

    public static void fillFile(String fileName){
        // чтение построчно
        String oneLine;

            System.out.println("Please, enter your text:");
            // создаем буферизованный ридер, для считывания с консоли
            // TO_DO: тут может быть как-то по-другому, потому что у меня есть класс консоль, в котором определн статичный Scanner
            // TO_DO: вообще это первая заготовка, поэтому может быть разбиение на классы не совсем корректно
            //  TO_DO: позже ещё обдумаю этот момент
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))
            ){
                while (!(oneLine = br.readLine()).equals("ESC")) {
                    // то есть каждую строку сбрасываем с буфера
                    // TO_DO: это безопасно, но слишком частые обращаения к диск
                    bw.write(oneLine + "\n");
                    bw.flush();
                }

                // TO_DO: наверное тоже должен быть в обработчике
                bw.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
