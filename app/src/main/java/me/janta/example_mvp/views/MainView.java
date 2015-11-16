package me.janta.example_mvp.views;

import java.util.ArrayList;

import me.janta.example_mvp.models.Element;

/**
 * Created by Jorge on 30/10/15.
 */
public interface MainView {
    void setElements(ArrayList<Element> elements);

    void addElement(String name, String Description);

}
