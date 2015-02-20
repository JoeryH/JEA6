package controller.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.WebLogService;

public class GetWeblog extends Command {
    
    private static final WebLogService webLogService = WebLogService.instance();
    
    static {
        CommandFactory.instance().registerCommand("/weblog", new GetWeblog());
    }

    public GetWeblog() {
    }

    public GetWeblog(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws ServletException, IOException {
        request.setAttribute("postings", webLogService.getPostings());
        request.getRequestDispatcher("/WEB-INF/view/weblog.jsp").forward(request, response);
    }

    @Override
    public Command createCommand(HttpServletRequest request, HttpServletResponse response) {
        return new GetWeblog(request, response);
    }
    
}
