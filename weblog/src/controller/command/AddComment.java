package controller.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Posting;
import service.WebLogService;

public class AddComment extends Command {

    private static final WebLogService webLogService = WebLogService.instance();

    static {
        CommandFactory.instance().registerCommand("/weblog/addComment", new AddComment());
    }

    public AddComment() {
    }

    public AddComment(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String comment = request.getParameter("comment");
        if (comment != null && !comment.isEmpty()) {
            webLogService.addComment(id, comment);
        }
    }

    @Override
    public Command createCommand(HttpServletRequest request, HttpServletResponse response) {
        return new AddComment(request, response);
    }

}
