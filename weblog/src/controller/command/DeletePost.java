package controller.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Posting;
import service.WebLogService;

public class DeletePost extends Command {

    private static final WebLogService webLogService = WebLogService.instance();

    static {
        CommandFactory.instance().registerCommand("/admin/deletePosting", new DeletePost());
    }

    public DeletePost() {
    }

    public DeletePost(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws ServletException, IOException {
        webLogService.deletePosting(Long.valueOf(request.getParameter("id")));
        response.sendRedirect("/weblog/admin");
    }

    @Override
    public Command createCommand(HttpServletRequest request, HttpServletResponse response) {
        return new DeletePost(request, response);
    }

}
