package someExamples;

/** класс для хранения Сервера, при разборе настроек конфига в формате JSON
 *
 * Created by poskotinova-ls on 27.07.2016.
 */
public class Server {
    private String serverName;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Server() {
    }

    @Override
    public String toString() {
        return "Server [serverName=" + serverName + "]";
    }
}
