package controller.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Posting;
import service.WebLogService;

public class AddPost extends Command {

    private static final WebLogService webLogService = WebLogService.instance();

    static {
        CommandFactory.instance().registerCommand("/admin/posting", new AddPost());
    }

    public AddPost() {
    }

    public AddPost(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws ServletException, IOException {
        String editId = request.getParameter("editId");
        if (editId != null) {
            Posting p = webLogService.getPosting(Long.valueOf(editId));
            p.setContent(request.getParameter("content"));
            p.setTitle(request.getParameter("title"));
        } else {
            Posting p = new Posting(request.getParameter("title"), request.getParameter("content"));
            webLogService.addPosting(p);
        }
        response.sendRedirect("/weblog/weblog");
    }

    @Override
    public Command createCommand(HttpServletRequest request, HttpServletResponse response) {
        return new AddPost(request, response);
    }

}
