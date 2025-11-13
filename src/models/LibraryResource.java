package models;
import java.util.List;


public class LibraryResource {
    private String id;
    private String title;
    private String content;

    public String getId() { return id;}
    public void setId(String id) {this.id = id.toUpperCase();}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String mainContent) {this.content = content;}
}


