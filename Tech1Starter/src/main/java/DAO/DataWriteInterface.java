package DAO;

import models.Content;

import java.util.logging.Logger;

/**
 * Created by jeppe on 11-05-2017.
 */
public interface DataWriteInterface {
    void addContent (Content content, Logger logger);
}
