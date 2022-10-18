package be.intecbrussel.servlets;
import be.intecbrussel.data.AuthorDaoImpl;
import be.intecbrussel.data.AuthorDaoInterface;
import be.intecbrussel.model.Author;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserDetailServlet")
public class UserDetailServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = null;
        Cookie[] cookies = req.getCookies();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")) userName = cookie.getValue();
            }
        }

        AuthorDaoInterface authorDao = new AuthorDaoImpl();
        Author author =  authorDao.findAuthorByUsername(userName);


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
                "    <title>Login Page</title>\n" +
                "</head>");
        out.println("<body style=\"background-image: url('https://images-na.ssl-images-amazon.com/images/I/91W5wBnDOUL._SL1500_.jpg');\">\n" +
                "<div class=\"container\">\n" +
                "    <div class=\"jumbotron\">\n" +
                "        <header style=\"text-align: center;\">\n" +
                "            <a class=\"headerText\" href=\"blogdetailpage.html\" style=\"color: white;\">Blog Central</a>\n" +
                "        </header>\n" +
                "    </div>\n" +
                "    <main role=\"main\" class=\"main-container\">\n" +
                "\n" +
                "        <div class=\"topnav bg-secondary\">\n" +
                "            <a class=\"nav-link\" href=\"#\">My Profile</a>\n" +
                "            <div class=\"search-container\">\n" +
                "                <form action=\"#\">\n" +
                "                    <input type=\"text\" placeholder=\"Search\" name=\"search\">\n" +
                "                    <button type=\"submit\"><i class=\"fa fa-search\"></i></button>\n" +
                "                </form>\n" +
                "            </div>\n" +
                "            <div class=\"login-container\">\n" +
                "            </div>\n" +
                "        </div>");

        out.println(" <div class=\"loginpage-container\">\n" +
                        " <form action=\"EditProfileServlet\">\n" +
                        "                   <input type=\"submit\" value = \"Edit Profile\">\n" +
                        "                </form>" +
                "                <h1>User Details</h1>\n" +
                "                <br>");

        out.print("<p>First name: ");
        out.println(author.getFirstName()==null?"Empty":author.getFirstName());
        out.println("<p");
        out.print("<p>Last name: ");
        out.println(author.getLastName()==null?"Empty":author.getLastName());
        out.println("<p");
        out.print("<p>User name: ");
        out.println(author.getUserName()==null?"Empty":author.getUserName());
        out.println("<p");
        out.print("<p>Email: ");
        out.println(author.getEmail()==null?"Empty":author.getEmail());
        out.println("<p");
        out.print("<p>Street: ");
        out.println(author.getStreet()==null?"Empty":author.getStreet());
        out.println("<p");
        out.print("<p>House Nr: ");
        out.println(author.getHouseNr()==null?"Empty":author.getHouseNr());
        out.println("<p");
        out.print("<p>Zip: ");
        out.println(author.getZip()==null?"Empty":author.getZip());

        out.println("</div>\n" +
                "\n" +
                "</main>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }
}
