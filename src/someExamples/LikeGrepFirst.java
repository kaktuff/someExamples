package someExamples;

import java.io.*;

/**
 * Created by poskotinova-ls on 18.04.2016.
 * Необходимо реализовать консольную программу, которая бы фильтровала поток текстовой информации подаваемой на вход
 * и на выходе показывала лишь те строчки, которые содержат слово передаваемое программе на вход в качестве аргумента.
 */
public class LikeGrepFirst {
    // нужно запускать из консоли, параметры: искомое слово, путь до файла, признак is_need_fill_file нужно ли заполнить файл перед началом работы
    // если нужно заполнить файл - вывести строку, введите данные и считать их из командной строки
    public static final String SEARCHPHRASE = "word";
    public static final int PARAMSCOUNT = 3;

    /**
     * Метод проверки вход параметров
     */
    public void chkArgs (String[] args){
        // проверить сначала длину массива
        if (args.length != PARAMSCOUNT){
            System.err.println("Incorrect param count");
        }
        else{
            // проверим, что последний параметр - это число in (0, 1)
        }
    }


    public static void main(String[] args) {
        // чтение построчно
        String oneLine;

        // создаем буферизованный ридер, для считывания с консоли
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\java_2016\\home.work\\likeGrepOutFile.txt"))
        ){

            while (!(oneLine = br.readLine()).equals("ESC")) {
                //bw.write(oneLine + "\n\r");
                bw.write(oneLine + "\n");
                //bw.write("\n\r");
                //bw.write("\n");
                // то есть каждую строку сбрасываем с буфера
                // TO_DO: это безопасно, но слишком частые обращаения к диск
                // TO_DO: плюс посмотреть по теории делается ли закрытие файла автоматом
                bw.flush();





            }

            //bw.write("Before close" + "\n");
            //bw.flush();
            // TO_DO: наверное тоже должен быть в обработчике
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //TO_DO: разбить на классы и методы, продумать правильную структуру
        //теперь организуем поиск по файлу
        // будем считывать построчно и искать в строке подстроку
        oneLine = null;
        try(BufferedReader fr = new BufferedReader (new FileReader("d:\\java_2016\\home.work\\likeGrepOutFile.txt"))){
            while ((oneLine = fr.readLine()) != null) {
                //TO_DO: тут сделать не sout, а нормально вывод в поток, хотя хз как лучше
                if (oneLine.contains(SEARCHPHRASE)){
                    System.out.println(oneLine);
                }
            }
        }
        catch(FileNotFoundException fileNotFoundEx){
            fileNotFoundEx.getMessage();
        }
        catch(IOException ioEx){
            ioEx.getMessage();
        }
    }
}
