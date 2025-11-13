package models;
import java.util.List;


public class LibraryResource {
    private String nodeid;
    private String title;
    private String content;

    public String getNodeid() { return nodeid;}
    public void setNodeid(String nodeid) {this.nodeid = nodeid.toUpperCase();}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String mainContent) {this.content = content;}
}


