package someExamples;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.FileInputStream;

/** Класс для считывания конфига
 *
 * Created by poskotinova-ls on 27.07.2016.
 */
public class ConfigReader {
    public static void main(String[] args) {
        //TODO: тут тоже будет иначе, когда корректно обработаем ошибку ниже
        try {
            readConfig();
        }
        catch (Exception ex){
            //System.out.println("error");;
            ex.printStackTrace();
        }
    }

    //TODO: взяла из примера. но "public static void" мне кжается можно на что-то изменить
    //TODO: throws Exception надо убрать и сделать корректную обработку new FileInputStream("C:\\work\\git\\someExamples\\src\\someExamples\\ConfigReader.java"),
    //TODO: которая и выбрасывает ошибку
    public static void readConfig() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Server server = (Server)mapper.readValue(new FileInputStream("C:\\work\\git\\someExamples\\src\\someExamples\\config.json"), Server.class);

        System.out.println(server);
    }
}

// такой вариант- работает ok
// Server [serverName=test]
//{
//        "serverName":"test"
//}