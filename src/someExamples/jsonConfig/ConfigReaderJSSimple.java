package someExamples.jsonConfig;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by poskotinova-ls on 28.07.2016.
 */
public class ConfigReaderJSSimple {
    private static final String filePath = "C:\\work\\git\\someExamples\\src\\someExamples\\jsonConfig\\config.json";

    public static void main(String[] args) {
        try{
            // read the json file
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(reader);

            // get a String from the JSON object
            //JSONObject  serverName = (JSONObject) jsonObject.get("fxb2");
            //System.out.println(serverName.get("bonusApiWs"));
            System.out.println("login - " +
                    ((JSONObject)((JSONObject) ((JSONObject) jsonObject.get("fxb2")).get("bonusApiWs")).get("mobileLibertex")).get("login")
                    + ", passw - " +
                    ((JSONObject)((JSONObject) ((JSONObject) jsonObject.get("fxb2")).get("bonusApiWs")).get("mobileLibertex")).get("passw")
            );

        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
