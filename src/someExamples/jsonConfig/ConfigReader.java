package someExamples.jsonConfig;

//import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;

//import org.json.*;

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

// аннотации, порядок считаывания ?
    // возожно как-то так парсить нужно
   // public static void readConfigJsArr(){
        // JSONObject response_json = (JSONObject) new JSONParser().parse(response_string);
        //JSONArray requisites_json = (JSONArray)(response_json.get("requisites"));
//    for(Object requisite : requisites_json){
//        JSONObject requisite_json = (JSONObject) requisite;
//        JSONObject bankInfo_json = (JSONObject)(requisite_json.get("bankInfo"));
   // }
/*
String json = "{paramsArray: [\"first\", 100],"
            + "paramsObj: {one: \"two\", three: \"four\"},"
            + "paramsStr: \"some string\"}";

JSONParser parser = new JSONParser();

Object obj = parser.parse(json);
JSONObject jsonObj = (JSONObject) obj;
System.out.println(jsonObj.get("paramsStr"));
// some string

JsonObject jo = jsonObj.get("paramsObj");
System.out.println(jo.get("three"));
// four

JsonArray ja = jsonObj.get("paramsArray");
System.out.println(ja.get(1));
// 100
* */
//    public static void readConfigParser(){
//        JSONParser parser = new JSONParser();
//    }
    //TODO: взяла из примера. но "public static void" мне кжается можно на что-то изменить
    //TODO: throws Exception надо убрать и сделать корректную обработку new FileInputStream("C:\\work\\git\\someExamples\\src\\someExamples\\ConfigReader.java"),
    //TODO: которая и выбрасывает ошибку
    //TODO: вот тут пример http://j4web.ru/java-json/primer-ispolzovaniya-jackson-java-obekty-i-json.html
    public static Server readConfig() throws Exception{
        //try (BufferedReader configFile = new BufferedReader(new FileReader("D:\\git\\someExamples\\src\\someExamples\\jsonConfig\\config.json"))){
        // это ссылка для рабочего компа
        try (BufferedReader configFile = new BufferedReader(new FileReader("C:\\work\\git\\someExamples\\src\\someExamples\\jsonConfig\\config.json"))){
            ObjectMapper mapper = new ObjectMapper();
            Server server = (Server) mapper.readValue(configFile, Server.class);
            System.out.println(server);

            return server;
        }
    }
}

// такой вариант- работает ok
// Server [serverName=test]
//{
//        "serverName":"test"
//}
// хотела пихать в конфиги такой формат, но тогда точно нужна будет карта, а хотелось бы обойтись без неё
/*
{serverName: fxb2
        serviceName : bonusApi
        roleName:mibile
        login:
        passw:
        }
*/