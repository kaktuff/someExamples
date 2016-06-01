package someExamples;

import java.util.Scanner;

/**
 * Created by poskotinova-ls on 24.05.2016.
 */
public class LikeSortFirst {
    // константы:
    private String fileName;//имя файла для сортировки
    private SortType sortType;//тип сортировки
    private int isNeedFillFile; //признак - нужно ли заполнить файл перед началом работы
    // так скорее всего неправильно заводить коллекцию как атрибут
    // над структурой ещё подумать
    // нужно часто обрашаться к элементам, а записать в коллекцию по идее нужно одина раз?
    // или после обращений будем перезаписывать

// код, который надо потом заюзать
// выпадающий список сделать, по коллекции ENUM
// буду считывать тип сортировки как строку
// по этой строке искать объект из SortType
// и этот поиск надо обернуть в обработчик, т.к. вдруг будет передано некорреткное значение
/*
String name = "WINTER";
Season season = Season.valueOf(name);

В результате выполнения кода переменная season будет равна Season.WINTER.
Cледует обратить внимание, что если элемент не будет найден, то будет выброшен IllegalArgumentException,
а в случае, если name равен null - NullPointerException. Об этом, кстати, часто забывают.
Почему-то многие твердо уверенны, что если функция принимает один аргумент и при некоторых услових выбрасывает IllegalArgumentException,
то при передачи туда null, также будет неприменно выброшен IllegalArgumentException.
* */

    public LikeSortFirst(String fileName, SortType sortType, int isNeedFillFile) {
        this.fileName = fileName;
        this.sortType = sortType;
        this.isNeedFillFile = isNeedFillFile;
    }
/*
    public LikeSortFirst(String fileName) {
        this(fileName, SortType.ALPHABETICALLY);
    }

    public LikeSortFirst() {
    }

    public void readFileToCollection() {

    }
*/
    /**
     * Метод проверки вход параметров
     * не буду детально заморачиваться, потому что по сути это не так важно, в данном случае главное концепт
     */
    /*
    public static void chkArgs (String[] args){
        // проверить сначала длину массива
        if (args.length != PARAMSCOUNT){
            System.err.println("Incorrect param count");
        }
        else{
            // проверим, что последний параметр - это число in (0, 1)
        }
    }
    */
/*
сделаю с GUI окошечком, в котором буду вводить адрес файла
тип сортировки выбрать из выпадающего списка

обработчики на наличие файла и тд
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
        Scanner scannerIn = new Scanner(System.in);
        Integer isNeedFillFile = scannerIn.nextInt();

        while (isNeedFillFile != 1 & isNeedFillFile != 0) {
            System.out.println("Вы ввели недопустимое значение. Введите одно из допустимых Y/N");
            isNeedFillFile = scannerIn.nextInt();
        }

        System.out.println("Введите путь до файла(существующего или того, что будем создавать)");
        String fileName = scannerIn.nextLine();

        System.out.println("Выберите тип сортировки:");
        // тут надо предложить все варианты, которые есть в Enum SortType
    }
}
