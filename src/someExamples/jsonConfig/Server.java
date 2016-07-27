package someExamples.jsonConfig;

/** класс для хранения Сервера, при разборе настроек конфига в формате JSON
 *
 * Created by poskotinova-ls on 27.07.2016.
 */
public class Server {
    private Service fxb2;
    private String fxb3;
    private String fxb4;

    public Service getFxb2() {
        return fxb2;
    }

    public Server() {
    }

    public String getFxb3() {
        return fxb3;
    }

    public String getFxb4() {
        return fxb4;
    }

    @Override
    public String toString() {
        return "Server [fxb2=" + fxb2.toString() +
                       " fxb3=" + fxb3 +
                       " fxb4=" + fxb4 +
                       "]";
    }
}
