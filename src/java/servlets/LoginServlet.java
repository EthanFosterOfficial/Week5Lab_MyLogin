package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

public class LoginServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        HttpSession session = request.getSession();

        String logParam = request.getParameter("logout");
        if (logParam != null)
        {
            request.setAttribute("message", "You have sucessfully logged out.");
            session.invalidate();
            session = request.getSession();
        }
        
        String username = (String) session.getAttribute("username");
        if (username != null)
        {
            response.sendRedirect("home");
        } else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username == null || username.equals("") || password == null || password.equals(""))
        {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", "Username or Password is empty.");

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }

        AccountService acctServ = new AccountService();
        User user = acctServ.login(username, password);

        if (user == null)
        {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", "Failed Authentication.");

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            response.sendRedirect("home");
        }

    }
}
