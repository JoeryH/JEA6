package controller.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.WebLogService;

public class GetAdmin extends Command {
    
    private static final WebLogService webLogService = WebLogService.instance();
    
    static {
        CommandFactory.instance().registerCommand("/admin", new GetAdmin());
    }

    public GetAdmin() {
    }

    public GetAdmin(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws ServletException, IOException {
        request.setAttribute("postings", webLogService.getPostings());
        request.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(request, response);
    }

    @Override
    public Command createCommand(HttpServletRequest request, HttpServletResponse response) {
        return new GetAdmin(request, response);
    }
    
}
