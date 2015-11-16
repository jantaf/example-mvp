package me.janta.example_mvp.presenters;

import java.util.ArrayList;

import me.janta.example_mvp.models.Element;
import me.janta.example_mvp.models.MainInteractor;
import me.janta.example_mvp.views.MainView;


public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;
    private MainInteractor mainInteractor;
    public MainPresenterImpl(MainView mainView)
    {
        this.mainView=mainView;
        this.mainInteractor=new MainInteractor(this);
    }

    @Override
    public void loadElementsInList(ArrayList <Element> elements) {
        mainView.setElements(elements);
    }

    @Override
    public void getElementsFromData() {
        mainInteractor.loadElements();
    }

    @Override
    public void addElement(String name, String description) {
        mainInteractor.addElement(name,description);
    }

    @Override
    public void getItemPosition(int position) {
        mainInteractor.removeElement(position);
    }
}
