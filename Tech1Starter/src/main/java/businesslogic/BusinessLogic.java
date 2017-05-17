package businesslogic;

import DAO.DAO;
import DAO.DataReader;
import DAO.DataWriter;
import DAO.DataReadInterface;
import DAO.DataWriteInterface;
import models.Content;
import models.ContentList;
import models.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jeppe on 30-03-2017.
 */
public class BusinessLogic implements BLInterface {
    private DataReadInterface dataRead;
    private DataWriteInterface dataWrite;

    public BusinessLogic() {
        this.dataRead = new DataReader();
        this.dataWrite = new DataWriter();
    }

    @Override
    public User checkUser(User user, Logger logger) {
        return dataRead.checkUser(user, logger);
    }

    @Override
    public void addContent(String contentString, Logger logger) throws IOException {
        Content content = new Content(contentString);
        dataWrite.addContent(content, logger);
    }

    @Override
    public List getContent(Logger logger) {
        List contentArraylist = new ArrayList<Content>();
        ContentList contentList = dataRead.getContent(logger);
        for(Content c : contentList.getContentList()){
            contentArraylist.add(c);
        }
        return contentArraylist;
    }
}
