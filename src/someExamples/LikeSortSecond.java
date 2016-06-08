package someExamples;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by poskotinova-ls on 24.05.2016.
 */
public class LikeSortSecond {
    // константы:
    private String fileName;//имя файла для сортировки
    private SortType sortType;//тип сортировки
    private int isNeedFillFile; //признак - нужно ли заполнить файл перед началом работы
    // так скорее всего неправильно заводить коллекцию как атрибут
    // над структурой ещё подумать
    // нужно часто обрашаться к элементам, а записать в коллекцию по идее нужно одина раз?
    // или после обращений будем перезаписывать

    public LikeSortSecond(String fileName, SortType sortType, int isNeedFillFile) {
        this.fileName = fileName;
        this.sortType = sortType;
        this.isNeedFillFile = isNeedFillFile;
    }
/*
сделаю с GUI окошечком, в котором буду вводить адрес файла
тип сортировки выбрать из выпадающего списка
* */

    public static void main(String[] args) {

        // сделать по умному как-то, типа будет один основной класс, который запустит форму, создаст объект типа LikeSortFirst
        // и вызовет уже у метода соотвествующие методы
        // не будет пока формы, когда-нибудь потом потом
//getParams;
        //chkArgs(args);
        //LikeSortFirst likeSortFirst = new LikeSortFirst("E:\\java_2016\\fileForLikeSort.txt");
        // создадим объект сначала без параметров
        // должно быть два объекта
        // 1 - взаимодействия с пользователем
        // 2 - хз пока
//LikeSortFirst likeSortFirst = new LikeSortFirst();
        //
//likeSortFirst.readFileToCollection();
        /*
        System.out.println("Хотите отсортировать существующий файл? Y/N, 1 - да, 0 - нет. введу данные с консоли");
        Scanner scannerIn = new Scanner(System.in);
        String answer = scannerIn.nextLine();

        while (answer != Constant.ANSWER_Y.toString() & answer != Constant.ANSWER_N.toString()) {
            System.out.println("Вы ввели недопустимое значение. Введите одно из допустимых Y/N");
            answer = scannerIn.nextLine();
        }

        System.out.println("Введите путь до файла");
        String fileName = scannerIn.nextLine();
        */
        System.out.println("Хотите создать файл? Y/N, 1 - да. введу данные с консоли, 0 - нет. Файл уже существует");

        Console console = new Console();

        int isNeedFillFile ;
        // передадим потом это значение в объект LikeSort при создании
        isNeedFillFile = console.readMark();


        Scanner scannerIn = new Scanner(System.in);
        //обработчики на наличие файла и тд
        // считывание имени файла и проверку на его существование лучше вынести в отдельный метод
        System.out.println("Введите путь до файла(существующего или того, что будем создавать)");
        String fileName = scannerIn.nextLine();


        // тоже лучше считывание и проверку на допустимые значения вынести в отдельный файл
        // плохо только, чот будет создаваться много оюъектов типа scaner, пока не знаю как от этого уйти
        System.out.println("Выберите тип сортировки, допустимые значения: " + Arrays.toString(SortType.values()));
        String stringReadedSortType = scannerIn.nextLine();// строка считанная с консоли

        // проверим корректность вводимых данных\
        int isCorrectSortType = 0;
        String  readOurSout;
        while (isCorrectSortType == 0) {
           try {
               SortType readedSortType = SortType.valueOf(stringReadedSortType); //считанное значение из консоли пытаемся преобразовать к типу SortType
               isCorrectSortType = 1;
           }
           // ошибка возникает, если ввели значение, которго нет в Enum типе
           catch (IllegalArgumentException illegalArgEx){
               System.out.println("Вы ввели недопустимое значение для Типа сортировки. Посмотрите допустимые значения и попробуйте ещё раз:");
               //readOurSout = scannerIn.nextLine();
               stringReadedSortType = scannerIn.nextLine();// строка считанная с консоли
               System.out.println("isNeedFillFile - " + isNeedFillFile);
               System.out.println("fileName - " + fileName);
               System.out.println("stringReadedSortType - " + stringReadedSortType);
           }
           // это ошибка возникает, если при проверке нахождения строки как значения Enum передано null значение
           catch (NullPointerException nullPointEx){
               System.out.println("Вы не ввели никакого значения. Выберите пожалуйста из списка:");
               readOurSout = scannerIn.nextLine();
           }
        }

// врернуть, когда весь нужный код напишу для работы с sortType
//LikeSortSecond likeSortSecond = new LikeSortSecond(fileName, sortType, isNeedFillFile);

        //хочу теперь просто вывести значения переменных
        // потому что в бесплатной intelliJ не доступен debug
        // логгировать пока не умею, потом заменить на логи
        System.out.println("isNeedFillFile - " + isNeedFillFile);
        System.out.println("fileName - " + fileName);
        System.out.println("stringReadedSortType - " + stringReadedSortType);

    }
}
