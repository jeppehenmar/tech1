package controller;

import businesslogic.BLInterface;
import businesslogic.BusinessLogic;
import models.Content;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by faisaljarkass on 22-10-2016.
 */
public class HomeController extends HttpServlet {

    private static Logger logger = Logger.getLogger(HomeController.class.getName());
    private BLInterface bl = new BusinessLogic();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        logger.log(Level.INFO, "doPost start...");
        logger.log(Level.INFO, "Username: " + username);
        logger.log(Level.INFO, "Password: " + password);
        logger.log(Level.INFO, "Checkbox: " + request.getParameter("rememberMe"));

        HttpSession session = request.getSession();

        List<Content> contentList = bl.getContent(logger);

        session.setAttribute("contentList", contentList);

        User user = bl.checkUser(new User(username, password), logger);
        if (user.isChecked() && user.getType().getType().equals("admin")) {
            //If user is valid, and admin, directed to admin page.
            RequestDispatcher rd = request.getRequestDispatcher("/loginSuccessAdmin.jsp");
            rd.forward(request, response);

        } else if(user.isChecked() && user.getType().getType().equals("user")){
            //If user is valid, but not admin, directed to user page.
            RequestDispatcher rd = request.getRequestDispatcher("/loginSuccess.jsp");
            rd.forward(request, response);

        } else {
            //If user credentials are not valid!
            logger.log(Level.INFO, "creds invalid");
            request.setAttribute("errorMessage", "true");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
