package be.intecbrussel.servlets;

import be.intecbrussel.data.AuthorDaoImpl;
import be.intecbrussel.data.AuthorDaoInterface;
import be.intecbrussel.model.Author;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
    AuthorDaoInterface authorDao = new AuthorDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String userName = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) userName = cookie.getValue();
            }
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        Author author = authorDao.findAuthorByUsername(userName);


        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"myStyle.css\">\n" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\n" +
                "    <script src=\"https://kit.fontawesome.com/18f81f1081.js\" crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"/script.js\"></script>\n" +
                "    <title>Register Page</title>\n" +
                "</head>\n" +
                "\n" +
                "<body style=\"background-image: url('https://images-na.ssl-images-amazon.com/images/I/91W5wBnDOUL._SL1500_.jpg');\">\n" +
                "<div class=\"container\">\n" +
                "    <div class=\"jumbotron\">\n" +
                "        <header style=\"text-align: center;\">\n" +
                "            <a class=\"headerText\" href=\"blogdetailpage.html\" style=\"color: white;\">Blog Central</a>\n" +
                "        </header>\n" +
                "    </div>\n" +
                "    <main role=\"main\" class=\"main-container\">\n" +
                "\n" +
                "        <div class=\"topnav bg-secondary\">\n" +
                "            <div class=\"search-container\">\n" +
                "                <form action=\"#\">\n" +
                "                    <input type=\"text\" placeholder=\"Search\" name=\"search\">\n" +
                "                    <button type=\"submit\"><i class=\"fa fa-search\"></i></button>\n" +
                "                </form>\n" +
                "            </div>\n" +
                "            <div class=\"login-container\">\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n");


        out.println("        <div class=\"loginpage-container\">" +
                "<form  method=\"post\">" +
                "        <h2> Please input changes for user: " + author.getFirstName() + " " + author.getLastName());

        out.println("</h2><br>");

        out.println(" Username :<br>\n" +
                "                <input type=\"text\" name=\"username\" placeholder=\"" + author.getUserName() + "\">\n" +
                "                <br> <br>");
        out.println(" Email :<br>\n" +
                "                <input type=\"text\" name=\"email\" placeholder=\"" + author.getEmail() + "\">\n" +
                "                <br> <br>");
        out.println(" Street :<br>\n" +
                "                <input type=\"text\" name=\"street\" placeholder=\"" + author.getStreet() + "\">\n" +
                "                <br> <br>");
        out.println(" HouseNr :<br>\n" +
                "                <input type=\"text\" name=\"housenr\" placeholder=\"" + author.getHouseNr() + "\">\n" +
                "                <br> <br>");
        out.println(" Zip :<br>\n" +
                "                <input type=\"text\" name=\"zip\" placeholder=\"" + author.getZip() + "\">\n" +
                "                <br> <br>");
        out.println(" password :<br>\n" +
                "                <input type=\"text\" name=\"password\" placeholder=\"please input your password\">\n" +
                "                <br> <br>");
        out.println(" Retype password :<br>\n" +
                "                <input type=\"text\" name=\"retypepassword\" placeholder=\"please retype password if you want to change password\">\n" +
                "                <br> <br>");
        out.println("                <button type=\"submit\" class=\"btn btn-secondary\">Edit\n" +
                "                </button>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "\n" +
                "    </main>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String userName = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) userName = cookie.getValue();
            }
        }

        Author author = authorDao.findAuthorByUsername(userName);


        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String street = req.getParameter("street");
        String houseNr = req.getParameter("housenr");
        String city = req.getParameter("city");
        String zip = req.getParameter("zip");


        String password = req.getParameter("password");
        String retypePassword = req.getParameter("retypepassword");

        if(password != null && retypePassword!=null){
            if(password.equals(retypePassword)){
                author.setPassword(password);
            }
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/EditProfileServlet");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Please input password again</font>");
            rd.include(req,resp);
        }

        author.setUserName(username);

        author.setEmail(email);

        author.setStreet(street);

        author.setHouseNr(houseNr);

        author.setCity(city);

        author.setZip(zip);


        authorDao.updateAuthor(author);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserDetailServlet");
        rd.forward(req, resp);

    }
}
