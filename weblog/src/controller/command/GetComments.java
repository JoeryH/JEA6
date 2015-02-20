package controller.command;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comment;
import model.Posting;
import service.WebLogService;

public class GetComments extends Command {

    private static final WebLogService webLogService = WebLogService.instance();

    static {
        CommandFactory.instance().registerCommand("/comments", new GetComments());
    }

    public GetComments() {
    }

    public GetComments(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        Posting p = webLogService.getPosting(id);
        try (PrintWriter out = new PrintWriter(response.getOutputStream())) {
            out.append("<comments>");
            for (Comment c : p.getComments()) {
                out.append("<comment><content>" + c.getContent() + "</content></comment>");
            }
            out.append("</comments>");
        }
    }

    @Override
    public Command createCommand(HttpServletRequest request, HttpServletResponse response) {
        return new GetComments(request, response);
    }

}
