package controller.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SwitchMode extends Command {

    static {
        CommandFactory.instance().registerCommand("/admin/switch", new SwitchMode());
    }

    public SwitchMode() {
    }

    public SwitchMode(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("mode", Boolean.valueOf(request.getParameter("mode")));
        response.sendRedirect("/weblog/admin");
    }

    @Override
    public Command createCommand(HttpServletRequest request, HttpServletResponse response) {
        return new SwitchMode(request, response);
    }
}
