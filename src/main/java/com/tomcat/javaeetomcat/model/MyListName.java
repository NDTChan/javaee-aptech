package com.tomcat.javaeetomcat.model;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class MyListName implements MyListNameLocal {

    public List<String> stringList = new ArrayList<>();

    @Override
    public void addName(String name) {
        stringList.add(name);
    }

    @Override
    public List<String> getNames() {
        return stringList;
    }

    @Override
    public boolean removeName(String name) {
        if (stringList.contains(name)) {
            return stringList.remove(name);
        }
        return false;
    }
}
