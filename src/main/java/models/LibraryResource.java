package models;

//***This class is storing the NodeID along with title and content***

public class LibraryResource {
    private String node;
    private String title;
    private String content;

    //***Getter and Setter methods are used in order to access and modify private fields***
    //Gets = returns the value of string
    //Set = sets the value of string
    public String getNodeid() { return node;}
    public void setNodeid(String nodeid) {this.node = nodeid.toUpperCase();}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) {this.content = content; }
}


