package someExamples;

import javax.swing.*;

/**
 * Created by poskotinova-ls on 24.05.2016.
 */
public class LikeSortFirst {
    private String fileName;//имя файла для сортировки
    private SortType sortType;//тип сортировки

// пример приведен для дальнейшего использования
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

/*
сделаю с GUI окошечком, в котором буду вводить адрес файла
тип сортировки выбрать из выпадающего списка
текстовое поле для ввода имени файла

обработчики на наличие файла и тд
* */

    public static void main(String[] args) {
        JFrame frame = new JFrame("Интерфейс для сортировки файла");

    }
}
