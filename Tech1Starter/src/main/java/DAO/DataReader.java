package DAO;

import models.Content;
import models.ContentList;
import models.User;
import models.UserType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jeppe on 06-04-2017.
 */
public class DataReader extends DAO  implements DataReadInterface {

    public User checkUser(User user, Logger logger) {
        try{
            Class.forName(JDBC_DRIVER);
            Connection con = DriverManager.getConnection(DATABASE_URL, USERNAME, USER_PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while(rs.next()){
                if(user.getUsername().equals(rs.getString(1))){
                    if(user.getPassword().equals(rs.getString(2))){
                        user.setType(new UserType(rs.getString(3)));
                        user.setChecked(true);
                        return user;
                    }
                }
            }
            return user;
        } catch (Exception e){
            e.printStackTrace();
            logger.log(Level.INFO, "Exception thrown");
        }
        return user;
    }

    public ContentList getContent(Logger logger){
        ContentList contentList = new ContentList();
        try{
            Class.forName(JDBC_DRIVER);
            Connection con = DriverManager.getConnection(DATABASE_URL, USERNAME, USER_PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM content");
            while(rs.next()){
                Content c = new Content(rs.getInt(1), rs.getString(2));
                contentList.addToList(c);
            }
            return contentList;
        } catch (Exception e){
            e.printStackTrace();
            logger.log(Level.INFO, "Exception thrown " + e);
        }
        return contentList;
    }
}
