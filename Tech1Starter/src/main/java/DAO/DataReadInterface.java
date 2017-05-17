package DAO;

import models.ContentList;
import models.User;

import java.util.logging.Logger;

/**
 * Created by jeppe on 11-05-2017.
 */
public interface DataReadInterface {
    User checkUser(User user, Logger logger);
    ContentList getContent(Logger logger);
}
