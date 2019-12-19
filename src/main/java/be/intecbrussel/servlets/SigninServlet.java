package be.intecbrussel.servlets;


import be.intecbrussel.data.AuthorDaoImpl;
import be.intecbrussel.data.AuthorDaoInterface;
import be.intecbrussel.model.Author;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {

    AuthorDaoInterface authorDao = new AuthorDaoImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String userName = req.getParameter("userName");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String street = req.getParameter("street");
        String houseNr = req.getParameter("houseNr");
        String city = req.getParameter("city");
        String zip = req.getParameter("zip");
        String password = req.getParameter("password");
        String retypePassword = req.getParameter("retypepassword");

        if(password.equals(retypePassword)){
            Author author = new Author()

                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserName(userName)
                    .setEmail(email)
                    .setStreet(street)
                    .setHouseNr(houseNr)
                    .setCity(city)
                    .setZip(zip)
                    .setPassword(password);

            authorDao.createNewAuthor(author);

            //als signin lukt wordt je doorverwezen naar de loginpage
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginpage.html");
            rd.forward(req,resp);

        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/registerpage.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Please input password again</font>");
            rd.include(req,resp);
        }

    }

}
