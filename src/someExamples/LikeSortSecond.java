package someExamples;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by poskotinova-ls on 24.05.2016.
 */
public class LikeSortSecond {
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

    public int getIsNeedFillFile() {
        return isNeedFillFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void fillFile(){
        if (this.getIsNeedFillFile() == 1){
            Console.fillFile(this.getFileName());
        }
    }

    public void doSort(){
        //зальем файл построчно в коллекцию и отсортируем её
        ArrayList<String> fileArrayList = new ArrayList<>();


    }

/*
потом сделаю с GUI окошечком, в котором буду вводить адрес файла
тип сортировки выбрать из выпадающего списка
я думаю надо вынести взаимодействие с пользователем ещё куда-то в отдельный класс, а то main получается какой-то загроможденный
* */

    public static void main(String[] args) {
        int isNeedFillFile ; // признак необходимости создания файла. передадим потом это значение в объект LikeSort при создании
        SortType sortType;
        System.out.println("Хотите создать файл? 1 - да. введу данные с консоли, 0 - нет. Файл уже существует");
        Console console = new Console();

        //считать признак необходимости заполнения файла
        isNeedFillFile = console.readMark();

        // считывание имени файла и проверку на его существование лучше вынести в отдельный метод
        // TO_DO: сейчас некритично, можно потом поучиться делать
        // TO_DO: проверить корректность пути
        // TO_DO: проверить, что если выбрали признак, что файл существует, что он действительно существует
//System.out.println("Введите путь до файла(существующего или того, что будем создавать)");
//String fileName = console.scannerIn.nextLine();

        Scanner scannerIn = new Scanner(System.in);
        //обработчики на наличие файла и тд
        // считывание имени файла и проверку на его существование лучше вынести в отдельный метод
        System.out.println("Введите путь до файла(существующего или того, что будем создавать). Для себя, пусть пока такой - C:\\work\\git\\someExamples\\src\\fileLikeSort.txt");
        String fileName = scannerIn.nextLine();

        //считать тип сортировки
        sortType = console.readSortType();

        // все данные считаны, создади объект
        LikeSortSecond likeSortSecond = new LikeSortSecond(fileName, sortType, isNeedFillFile);

        // заполним файл есть это необходимо, данными с консоли
        likeSortSecond.fillFile();

        // теперь запустим механизм сортировки
        System.out.println("isNeedFillFile - " + isNeedFillFile);
        System.out.println("fileName - " + fileName);
    }
}
