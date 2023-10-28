package com.tomcat.javaeetomcat.model;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface MyListNameLocal {
    void addName(String name);

    List<String> getNames();

    boolean removeName(String name);
}
