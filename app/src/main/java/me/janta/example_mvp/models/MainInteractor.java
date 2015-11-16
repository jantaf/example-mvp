package me.janta.example_mvp.models;

import java.util.ArrayList;

import me.janta.example_mvp.presenters.MainPresenter;

public class MainInteractor {
    private MainPresenter mainPresenter;
    private ArrayList<Element> elements;

    public MainInteractor(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
        elements = new ArrayList<>();

    }

    public void loadElements() {
        for (int i = 0; i < 10; i++) {
            Element element = new Element("Element " + i, String.valueOf(i));
            elements.add(element);
        }
        mainPresenter.loadElementsInList(elements);
    }

    public void addElement(String name, String description) {
        Element element = new Element(name, description);
        elements.add(element);
    }

    public void removeElement(int position) {
        elements.remove(position);
    }
}
