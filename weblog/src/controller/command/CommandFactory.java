package controller.command;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandFactory {
    
    private static CommandFactory instance = null;
    
    private final Map<String, Command> commands = new HashMap<>();
    
    private CommandFactory() {}
    
    public static CommandFactory instance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }
    
    public void registerCommand(String url, Command command) {
        commands.put(url, command);
    }
    
    public Command createCommand(String url, HttpServletRequest request, HttpServletResponse response) {
        Command command = commands.get(url);
        if (command == null) {
            command = commands.get(NotFound.URL);
        }
        return command.createCommand(request, response);
    }
    
    static {
        try {
            Class.forName("controller.command.NotFound");
            Class.forName("controller.command.GetWeblog");
            Class.forName("controller.command.GetAdmin");
            Class.forName("controller.command.GetComments");
            Class.forName("controller.command.AddPost");
            Class.forName("controller.command.DeletePost");
            Class.forName("controller.command.AddComment");
            Class.forName("controller.command.SwitchMode");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommandFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
