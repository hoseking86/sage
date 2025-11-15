package models;

public class LibraryResource {
    private String node;
    private String title;
    private String content;

    public String getNodeid() { return node;}
    public void setNodeid(String nodeid) {this.node = nodeid.toUpperCase();}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) {this.content = content; }
}


