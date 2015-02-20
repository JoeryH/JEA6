package controller;

import controller.command.Command;
import controller.command.CommandFactory;
import controller.command.NotFound;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Comment;
import model.Posting;
import service.WebLogService;

@WebServlet(name = "WeblogServlet", urlPatterns = {"/weblog", "/admin", "/admin/switch", "/admin/posting", "/weblog/addComment", "/comments", "/admin/deletePosting"})
public class WeblogServlet extends HttpServlet {
    
    private final WebLogService webLogService = WebLogService.instance();

    //private Command url = new NotFound();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        Command command = CommandFactory.instance().createCommand(userPath, request, response);
        command.execute();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }
}
