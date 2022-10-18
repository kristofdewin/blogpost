package be.intecbrussel.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Cookie loginCookie = null;
        Cookie[] cookies = req.getCookies();
        if(cookies !=null){
            for (Cookie cookieCurrentUser: cookies){
                if(cookieCurrentUser.getName().equals("user")){
                    loginCookie = cookieCurrentUser;
                    break;
                }
            }
        }
        if(loginCookie !=null){
            loginCookie.setMaxAge(0);
            resp.addCookie(loginCookie);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/bloghome.html");
        rd.forward(req, resp);
    }
}
