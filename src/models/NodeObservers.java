package models;

//https://www.youtube.com/watch?v=cR8P1HZAyP8 HELP WITH OBSERVER DESIGN PATTERN Accessed 17/11/2025
//Observer Design Pattern - Linked node visual update
//This is the interface for the design pattern - https://www.geeksforgeeks.org/system-design/observer-method-design-pattern-in-java/ Accessed 17/11/2025
public interface NodeObservers {
    void onNodeUpdated(Node node);
}
