package someExamples;

import java.util.Scanner;

/**
 * Created by poskotinova-ls on 03.06.2016.
 * объект для работы с консолью
 */
public class Console {
    /**
    * метод для считывния с консоли некоего признака - число, in (0, 1)
    * */
    public int readMark(){
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
}
