package someExamples.jsonConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;

/** Класс для считывания конфига
 *
 * Created by poskotinova-ls on 27.07.2016.
 *
 * подключенные библиотеки:
 * http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.8.1/
 * http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.8.1/
 * http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.8.1/
 */
public class ConfigReader {
    public static void main(String[] args) {
        //TODO: тут тоже будет иначе, когда корректно обработаем ошибку ниже
        try {
            //TODO: плохо получилось, потому что getFxb!2!
            System.out.println(ConfigReader.readConfig().getFxb2().getServiceName());
            //TODO: хотелось бы чтобы вызовы были вот такие getServer(environment).getService(serviceName).getRole(roleName) => {login, passw}
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //TODO: взяла из примера. но "public static void" мне кжается можно на что-то изменить
    //TODO: throws Exception надо убрать и сделать корректную обработку new FileInputStream("C:\\work\\git\\someExamples\\src\\someExamples\\ConfigReader.java"),
    //TODO: которая и выбрасывает ошибку
    //TODO: вот тут пример http://j4web.ru/java-json/primer-ispolzovaniya-jackson-java-obekty-i-json.html
    public static Server readConfig() throws Exception{
        try (BufferedReader configFile = new BufferedReader(new FileReader("D:\\git\\someExamples\\src\\someExamples\\jsonConfig\\config.json"))){
        // это ссылка для рабочего компа
        //try (BufferedReader configFile = new BufferedReader(new FileReader("C:\\work\\git\\someExamples\\src\\someExamples\\config.json"))){
            ObjectMapper mapper = new ObjectMapper();
            Server server = (Server) mapper.readValue(configFile, Server.class);
            System.out.println(server);

            return server;
        }
        //ObjectMapper mapper = new ObjectMapper();
        //Server server = (Server)mapper.readValue(new FileInputStream("C:\\work\\git\\someExamples\\src\\someExamples\\config.json"), Server.class);

        //System.out.println(server);
    }
}

// такой вариант- работает ok
// Server [serverName=test]
//{
//        "serverName":"test"
//}
// хотела пихать в конфиги такой формат
/*
{serverName: fxb2
        serviceName : bonusApi
        roleName:mibile
        login:
        passw:
        }
*/