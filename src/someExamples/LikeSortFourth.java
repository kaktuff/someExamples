package someExamples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author kaktuff on 24.05.2016.
 *         класс для реализации сортировки текстового файла(файл может быть либо уже существующий, либо созданный в рамках приложения)
 */
public class LikeSortFourth {
    private String fileName;//имя файла для сортировки
    private SortType sortType;//тип сортировки
    private boolean isNeedFillFile; //признак - нужно ли заполнить файл перед началом работы
    // TODO: так скорее всего неправильно заводить коллекцию как атрибут
    private List<String> fileList = new ArrayList<>();//коллекция для хранения данных файла построчно

    // сеттеры, геттеры
    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }

    public List<String> getFileList() {
        return fileList;
    }

    public LikeSortFourth(String fileName, SortType sortType, boolean isNeedFillFile) {
        this.fileName = fileName;
        this.sortType = sortType;
        this.isNeedFillFile = isNeedFillFile;
    }

    public boolean getIsNeedFillFile() {
        return isNeedFillFile;
    }

    public String getFileName() {
        return fileName;
    }

    public SortType getSortType() {
        return sortType;
    }

    /**
     * считывания и сохранение данных для сортировки с консоли
     */
    public void fillFile() {
        if (getIsNeedFillFile()) {
            Console.fillFileFromSystemIn(getFileName());
        }
    }

    /**
     * основной метод сортировки - преобразыует данные файла в коллекцию, сортирует её и сохраняет в файл в отосртированном виде
     */
    public void doSort() {
        // сначала сложим содержимое файла в коллекцию, отсортируем её и сохраним как параметр объекта
        setFileList(getSortedList());

        //теперь сохраним содержимое коллекции в файл
        Console.fillFile(getFileName(), getFileList());
    }

    /**
     * Преобразует файл в коллецию
     *
     * @return НЕотсортированная коллеция с данными файла - один элемент == 1 строке из файлв
     */
    public List<String> getNotSortedList() {
        // пусть пока будет ArrayList
        // но т.к. нам нужно делать много вставок, то из этих соображений лучше бы подошёл LinkedList
        List<String> fileListInner = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(getFileName()))) {
            // читаем построчно
            String oneStr;
            while ((oneStr = reader.readLine()) != null) {
                //System.out.println(oneStr);
                fileListInner.add(oneStr);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //System.out.println("длина коллекции == " + fileListInner.size());

        return fileListInner;
    }

    /**
     * Сортировка коллекции по Алфавиту
     *
     * @param iListForSort сортируемая коллекция
     */
    public void sortListAlphabetically(List<String> iListForSort) {
        Collections.sort(iListForSort, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.toString().compareTo(o2.toString());
                    }
                }
        );
    }

    /**
     * Сортировка коллекции по Длине строки по Возрастанию
     *
     * @param iListForSort сортируемая коллекция
     */
    public void sortListLengthStringAsc(List<String> iListForSort) {
        Collections.sort(iListForSort, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.length() - o2.length();
                    }
                }
        );
    }

    /**
     * Сортировка коллекции по Длине строки по Убыванию
     *
     * @param iListForSort сортируемая коллекция
     */
    public void sortListLengthStringDesc(List<String> iListForSort) {
        Collections.sort(iListForSort, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.length() - o1.length();
                    }
                }
        );
    }

    /**
     * Сортировка коллекции
     *
     * @param iListForSort колекция, которую нужно отсортировать  List<String>
     * @param iSortType    тип сортировки                         SortType
     */
    public void sortList(List<String> iListForSort, SortType iSortType) {
        if (iSortType == SortType.ALPHABETICALLY) {
            sortListAlphabetically(iListForSort);
        } else if (iSortType == SortType.LENGTH_STRING_ASC) {
            sortListLengthStringAsc(iListForSort);
        } else if (iSortType == SortType.LENGTH_STRING_DESC) {
            sortListLengthStringDesc(iListForSort);
        }
    }

    /**
     * перегрузка для метода sortList, типа с параметром по умолчанию для сортировки
     *
     * @param iListForSort колекция, которую нужно отсортировать  List<String>
     */
    public void sortList(List<String> iListForSort) {
        sortList(iListForSort, SortType.ALPHABETICALLY);
    }

    public List<String> getSortedList() {
        //зальем файл построчно в коллекцию и отсортируем её
        List<String> fileListInner = getNotSortedList();

        // метод для сортировки
        sortList(fileListInner, getSortType());
        System.out.println("отсортированная коллекция - " + fileListInner);
        return fileListInner;
    }

/*
потом сделаю с GUI окошечком, в котором буду вводить адрес файла
тип сортировки выбрать из выпадающего списка
я думаю надо вынести взаимодействие с пользователем ещё куда-то в отдельный класс, а то main получается какой-то загроможденный
* */

    public static void main(String[] args) {
        System.out.println("Хотите создать файл? 1 - да. введу данные с консоли, 0 - нет. Файл уже существует");
        Console console = new Console();

        //считать признак необходимости заполнения файла
        boolean isNeedFillFile = console.readMarkBoolean();// признак необходимости создания файла. передадим потом это значение в объект LikeSort при создании

        // считывание имени файла и проверку на его существование лучше вынести в отдельный метод
        // TODO: сейчас некритично, можно потом поучиться делать
        // TODO: проверить корректность пути
        // TODO: проверить, что если выбрали признак, что файл существует, что он действительно существует
//System.out.println("Введите путь до файла(существующего или того, что будем создавать)");
//String fileName = console.scannerIn.nextLine();

        Scanner scannerIn = new Scanner(System.in);
        // TODO: обработчики на наличие файла и тд
        // TODO: считывание имени файла и проверку на его существование лучше вынести в отдельный метод
        System.out.println("Введите путь до файла(существующего или того, что будем создавать). Для себя, пусть пока такой - C:\\work\\git\\someExamples\\src\\fileLikeSort.txt");
        String fileName = scannerIn.nextLine();

        //считать тип сортировки
        SortType sortType = console.readSortType();

        // все данные считаны, создади объект
        LikeSortFourth likeSortFourth = new LikeSortFourth(fileName, sortType, isNeedFillFile);

        // заполним файл есть это необходимо, данными с консоли
        likeSortFourth.fillFile();

        // теперь запустим механизм сортировки
        //System.out.println("isNeedFillFile - " + isNeedFillFile);
        //System.out.println("fileName - " + fileName);

        likeSortFourth.doSort();
    }
}
