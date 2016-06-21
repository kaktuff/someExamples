package someExamples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
    private List<String> fileList = new ArrayList<>();

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }

    public List<String> getFileList() {
        return fileList;
    }

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
            Console.fillFileFromSystemIn(this.getFileName());
        }
    }

    public void doSort(){
        // сначала получим коллекцию для файла, отсортируем её и сохраним как параметр объекта
        this.setFileList(this.getSortedList());

        //теперь сохраним содержимое коллекции в файл
        Console.fillFile(this.getFileName(), this.getFileList());
    }
    public List<String> getSortedList(){
        //зальем файл построчно в коллекцию и отсортируем её
        // пусть пока будет ArrayList
        // но т.к. нам нужно делать много вставок, то из этих соображений лучше бы подошёл LinkedList
        // TO_DO: перенос из файла в коллекцию - это тоже метод
        List<String> fileListInner = new ArrayList<>();

// это не подходит, надо считывание ПОСТРОЧНО

        try(BufferedReader reader = new BufferedReader(new FileReader(this.getFileName())))
        {
            // читаем построчно
            // TO_DO:  переименовать переменную по-человечески
            String str;
            while((str=reader.readLine())!= null){

                System.out.println(str);
                fileListInner.add(str);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        System.out.println("длина коллекции == " + fileListInner.size());

        // TO_DO: здесь должно быть ветвление по типу сортировки:(по сути это метод диспетчер)
        // TO_DO: то есть по суди IF и для каждого типа сортировки свой метод
        // взяла готовый пример
        // TO_DO: поискать другие варианты, плюс научиться писать этот код самомтсоятельно, чтоб от зубов отскакивал
        Collections.sort(fileListInner, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.toString().compareTo(o2.toString());
                    }
                }
        );

        // теперь нужно вывести коллекцию на экран
        // TO_DO: вынести конечно же в отдельный метод, пока просто отладка
        System.out.println(fileListInner);

        // по-хорошему, мы же файл сортируем
        // поэтому нужно коллекцию целиком записать в файл и вывести его на экран
        return fileListInner;
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

        likeSortSecond.doSort();
    }
}
