/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author 726772
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String action = request.getParameter("logout");
        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "Successfully logged out!");
        }
        
        if(session.isNew()){
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        }
        else {
            response.sendRedirect("home");
        }    

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username.equals("") || username == null || password.equals("") || password == null){
            request.setAttribute("message", "Username and password cannot be empty.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
        }
        else{
            AccountService account = new AccountService();
            User user = account.login(username, password);
            
            if(user == null) {
                request.setAttribute("message", "Invalid username or password.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
            }
            else {
                HttpSession session = request.getSession();
                response.sendRedirect("home");
                session.setAttribute("user", user);
            }
        }
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
