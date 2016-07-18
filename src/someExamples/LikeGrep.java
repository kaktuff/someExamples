package someExamples;

import java.io.*;

/**
 * Created by poskotinova-ls on 18.04.2016.
 * Необходимо реализовать консольную программу, которая бы фильтровала поток текстовой информации подаваемой на вход
 * и на выходе показывала лишь те строчки, которые содержат слово передаваемое программе на вход в качестве аргумента.
 *
 * по идее можно реализовать без записи в файл, а только работу с консолью:
 * считываем с консоли и делаем сразу вывод, но не делаем flush, а flush только в самом конце
 * плюс такой реализации - можно grepать и файл и что-то с консоли
 *
 * как запускать из консоли
 * - зайти в папку проекта, на работе это:
 * E:\java_2016\src\src
 * - откомпилировать исходник
 * javac someExamples/LikeGrep.java
 * - запустить так
 * java someExamples.LikeGrep word E:\java_2016\src\likeGrepOutFile.txt 1
 */
public class LikeGrep {
    // константы:
    //public static final String SEARCHPHRASE = "word";
    public static final int PARAMSCOUNT = 3;

    // поля:
    private String searchWord; //искомое слово
    private String fileName; //путь до файла
    private int isNeedFillFile; //признак - нужно ли заполнить файл перед началом работы

    public String getSearchWord() {
        return searchWord;
    }

    public String getFileName() {
        return fileName;
    }

    public int getIsNeedFillFile() {
        return isNeedFillFile;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setIsNeedFillFile(int isNeedFillFile) {
        this.isNeedFillFile = isNeedFillFile;
    }

    public LikeGrep(String searchWord, String fileName, int isNeedFillFile) {
        this.searchWord = searchWord;
        this.fileName = fileName;
        this.isNeedFillFile = isNeedFillFile;
    }

    public LikeGrep() {
    }

    /**
     * Метод проверки вход параметров
     * не буду детально заморачиваться, потому что по сути это не так важно, в данном случае главное концепт
     */
    public static void chkArgs (String[] args){
        // проверить сначала длину массива
        if (args.length != PARAMSCOUNT){
            System.err.println("Incorrect param count");
        }
        else{
            // проверим, что последний параметр - это число in (0, 1)
        }
    }


    public void fillFile(){
        // чтение построчно
        String oneLine;

        System.out.println("Please, enter your text:");

        if (this.getIsNeedFillFile() == 1){
            // создаем буферизованный ридер, для считывания с консоли
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 BufferedWriter bw = new BufferedWriter(new FileWriter(this.getFileName()))
            ){
                while (!(oneLine = br.readLine()).equals("ESC")) {
                    // то есть каждую строку сбрасываем с буфера
                    // TODO: это безопасно, но слишком частые обращаения к диск
                    bw.write(oneLine + "\n");
                    bw.flush();
                }

                // TODO: наверное тоже должен быть в обработчике
                bw.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void searchWord(){
        String oneLine;

        System.out.println("Some string including searching word:");

        try(BufferedReader fr = new BufferedReader (new FileReader(this.getFileName()))){
            while ((oneLine = fr.readLine()) != null) {
                //TODO: тут сделать не sout, а нормально вывод в поток, хотя хз как лучше
                if (oneLine.contains(this.getSearchWord())){
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

    // нужно запускать из консоли, параметры: искомое слово, путь до файла, признак is_need_fill_file нужно ли заполнить файл перед началом работы
    // если нужно заполнить файл - вывести строку, введите данные и считать их из командной строки
    public static void main(String[] args) {
        // проверим входные параметры:
        chkArgs(args);

        // проверка прошла успешно, можно создать объект, которые будет хранить входящие данные
        LikeGrep likeGrep = new LikeGrep(args[0], args[1], Integer.parseInt(args[2]));

        // метод заполнения файла, если это необходимо
        likeGrep.fillFile();

        //теперь организуем поиск по файлу
        // будем считывать построчно и искать в строке подстроку
        likeGrep.searchWord();
    }
}
