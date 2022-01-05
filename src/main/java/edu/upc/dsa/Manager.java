package edu.upc.dsa;

import java.util.LinkedList;

public interface Manager {
    public LinkedList<Badge> getBadges();
    public User getUser(String userId);
}
