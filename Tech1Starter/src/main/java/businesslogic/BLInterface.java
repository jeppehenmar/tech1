package businesslogic;

import models.Content;
import models.ContentList;
import models.User;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jeppe on 30-03-2017.
 */
public interface BLInterface {
    User checkUser(User user, Logger logger) throws IOException;

    void addContent (String contentString, Logger logger) throws IOException;
    List getContent(Logger logger);
}
