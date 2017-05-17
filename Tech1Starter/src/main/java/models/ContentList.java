package models;

import java.util.ArrayList;

/**
 * Created by jeppe on 11-05-2017.
 */
public class ContentList {
    private ArrayList<Content> contentList;

    public ContentList() {
        this.contentList = new ArrayList<>();
    }

    public ContentList(ArrayList<Content> contentList) {
        this.contentList = contentList;
    }

    public ArrayList<Content> getContentList() {
        return contentList;
    }

    public void setContentList(ArrayList<Content> contentList) {
        this.contentList = contentList;
    }

    public void addToList(Content content){
        contentList.add(content);
    }
}
