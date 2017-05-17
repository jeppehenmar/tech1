package controller;

import DAO.DAO;
import businesslogic.BLInterface;
import businesslogic.BusinessLogic;
import models.Content;
import models.ContentList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContentController extends HttpServlet {
    private static Logger logger = Logger.getLogger(HomeController.class.getName());
    private BLInterface bl = new BusinessLogic();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String newContent = request.getParameter("newContent");

        logger.log(Level.INFO, "doPost start...");
        logger.log(Level.INFO, newContent);

        //Adding new content to database.
        bl.addContent(newContent, logger);

        logger.log(Level.INFO, "alt godt");

        //Fetching content from database.

        HttpSession session = request.getSession();

        List<Content> contentList = bl.getContent(logger);

        session.setAttribute("contentList", contentList);
        String redirect = response.encodeRedirectURL(request.getContextPath() + "/loginSuccessAdmin.jsp");
        response.sendRedirect(redirect);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
