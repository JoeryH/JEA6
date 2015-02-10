package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Posting;
import service.WebLogService;

@WebServlet(name = "WeblogServlet", urlPatterns = {"/weblog", "/admin", "/admin/addPosting"})
public class WeblogServlet extends HttpServlet {
    
    private final WebLogService webLogService = new WebLogService();

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
        
        String userPath = request.getServletPath();
                
        if (userPath.equals("/admin")) {
            
        } else if (userPath.equals("/weblog")) {
            request.setAttribute("postings", webLogService.getPostings());      
        }
        
        request.getRequestDispatcher("/WEB-INF/view" + userPath + ".jsp").forward(request, response);
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
        String userPath = request.getServletPath();
        
        if (userPath.equals("/admin/addPosting")) {
            Posting p = new Posting(request.getParameter("title"), request.getParameter("content"));
            webLogService.addPosting(p);
            response.sendRedirect("/weblog/weblog");
            return;
        }
        
        request.getRequestDispatcher("/WEB-INF/view" + userPath + ".jsp").forward(request, response);
    }
}
