package be.intecbrussel.servlets;

import be.intecbrussel.data.AuthorDaoImpl;
import be.intecbrussel.data.AuthorDaoInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    //login variables to be be retrieved in the db
    private String userNameDB = "john";
    private String passwordDB = "wazaa";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("name");
        String password = req.getParameter("password");

        AuthorDaoInterface authorDao = new AuthorDaoImpl();

        userNameDB = authorDao.findAuthorByUsername(user).getUserName();
        passwordDB = authorDao.findAuthorByUsername(user).getPassword();

        if(userNameDB.equals(user) && passwordDB.equals(password)){
            Cookie loginCookie = new Cookie ("user",user);
            //setting cookie to expire in 30 min
            loginCookie.setMaxAge(30*60);
            resp.addCookie(loginCookie);

            //resp.sendRedirect doesn't work. use requestdispatcher instead (not a blog since its on the same domain)
//            resp.sendRedirect("/blogdetailpage.html");

           RequestDispatcher rd = getServletContext().getRequestDispatcher("/blogdetailpage.html");
            rd.forward(req,resp);

        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginpage.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(req,resp);
        }

    }
}

