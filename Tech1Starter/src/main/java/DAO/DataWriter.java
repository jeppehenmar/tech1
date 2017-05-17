package DAO;

import models.Content;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jeppe on 11-05-2017.
 */
public class DataWriter extends DAO implements DataWriteInterface {
    @Override
    public void addContent(Content content, Logger logger) {
        try{
            Class.forName(JDBC_DRIVER);
            Connection con = DriverManager.getConnection(DATABASE_URL, USERNAME, USER_PASS);
            Statement stmt = con.createStatement();

            //Creating query string for prepared statement
            String query = "INSERT INTO content (content_id, content_string, date_created)" + "values(DEFAULT, ?, DEFAULT)";

            //Creating the prepared statement
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepStmt.setString(1, content.getContentString());

            //Executing the prepared statement
            prepStmt.execute();

            //Closing the connection
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
            logger.log(Level.INFO, "Exception thrown" + e);
        }
    }
}
