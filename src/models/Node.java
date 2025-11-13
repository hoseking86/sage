package models;

public class Node extends LibraryResource  {

    private String nodeid;
    public String getNodeid() { return nodeid; }
    public void setNodeid(String nodeid) { this.nodeid = nodeid; }


    private String title;
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title;}

    private String content;
    public String getContent() { return content; }
    public void setContent(String mainContent) { this.content = mainContent; }

    //added 13/11/2025 12:30 for the search
    @Override
    public String toString() {
        return "Node ID: " + nodeid
                + "  Title: " + title
                + "  Content: " + content;
        //end of search function
    }
}
