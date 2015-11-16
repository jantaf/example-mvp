package me.janta.example_mvp.presenters;

import java.util.ArrayList;

import me.janta.example_mvp.models.Element;

/**
 * Created by Jorge on 30/10/15.
 */
public interface MainPresenter {
    void loadElementsInList(ArrayList<Element> elements);

    void getElementsFromData();

    void addElement(String name, String Description);

    void getItemPosition(int position);

}
