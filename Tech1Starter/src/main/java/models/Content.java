package models;

/**
 * Created by jeppe on 11-05-2017.
 */
public class Content {
    private int contentId;
    private String contentString;

    public Content(String contentString) {
        this.contentString = contentString;
        this.contentId = 0;
    }

    public Content(int contentId, String contentString) {
        this.contentId = contentId;
        this.contentString = contentString;
    }

    public String getContentString() {
        return contentString;
    }

    public void setContentString(String contentString) {
        this.contentString = contentString;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }
}
