package br.org.indt.ndg.lwuit.control;

import br.org.indt.ndg.mobile.AppMIDlet;
import br.org.indt.ndg.mobile.httptransport.SecureHttpConnector;
import com.sun.lwuit.Command;

/**
 *
 * @author damian.janicki
 */
public class LoginCommand extends CommandControl{

    private static LoginCommand instance = null;

    public static LoginCommand getInstance(){
        if(instance == null){
            instance = new LoginCommand();
        }
        return instance;
    }

    protected Command createCommand() {
        return new Command("Login");//TODO localize
    }

    protected void doAction(Object parameter) {
        String[] paramsStr = (String[])parameter;
        SecureHttpConnector.setCredentials(paramsStr[0], paramsStr[1]);
        AppMIDlet.getInstance().showEncryptionScreen();
    }
}

