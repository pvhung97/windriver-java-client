package io.kanthis;

import static org.openqa.selenium.remote.DriverCommand.NEW_SESSION;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;

import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.http.ClientConfig;

public class WinDriverCommandExecutor extends HttpCommandExecutor {

    public WinDriverCommandExecutor(ClientConfig config) {
        super(config);
    }

    public WinDriverCommandExecutor(URL addressOfRemoteServer) {
        super(addressOfRemoteServer);
    }

    @Override
    public Response execute(Command command) throws IOException {
        Response response = super.execute(command);
        if (NEW_SESSION.equals(command.getName())) {
            try {
                Field commandCodec = null;
                commandCodec = this.getClass().getSuperclass().getDeclaredField("commandCodec");
                commandCodec.setAccessible(true);
                commandCodec.set(this, new WinDriverCommandCodec());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return response;
    }
    
}
