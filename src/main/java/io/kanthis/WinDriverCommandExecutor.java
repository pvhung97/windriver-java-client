package io.kanthis;

import static org.openqa.selenium.remote.DriverCommand.NEW_SESSION;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandCodec;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.ResponseCodec;
import org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec;
import org.openqa.selenium.remote.http.ClientConfig;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpResponse;

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
            setCommandCodec(new WinDriverCommandCodec());
            setResponseCodec(new W3CHttpResponseCodec());
        }
        return response;
    }

    public void setCommandCodec(CommandCodec<HttpRequest> newCodec) {
        try {
            Field commandCodec = null;
            commandCodec = HttpCommandExecutor.class.getDeclaredField("commandCodec");
            commandCodec.setAccessible(true);
            commandCodec.set(this, newCodec);
        } catch (Exception ex) {
            throw new WebDriverException(ex);
        }
    }

    public void setResponseCodec(ResponseCodec<HttpResponse> codec) {
        try {
            Field responseCodec = null;
            responseCodec = HttpCommandExecutor.class.getDeclaredField("responseCodec");
            responseCodec.setAccessible(true);
            responseCodec.set(this, codec);
        } catch (Exception ex) {
            throw new WebDriverException(ex);
        }
    }
    
}
