package controller.command;

import java.io.IOException;
import javax.ejb.Startup;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Startup
public class NotFound extends Command {
    
    public static final String URL = "notFound";
    
    static {
        CommandFactory.instance().registerCommand(URL, new NotFound());
    }

    public NotFound() {
    }

    public NotFound(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }
    
    @Override
    public void execute() throws ServletException, IOException {
        response.setStatus(404);
        request.getRequestDispatcher("/WEB-INF/view/404.jsp").forward(request, response);
    }

    @Override
    public Command createCommand(HttpServletRequest request, HttpServletResponse response) {
        return new NotFound(request, response);
    }
}
