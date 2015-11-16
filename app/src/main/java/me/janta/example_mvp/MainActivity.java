package me.janta.example_mvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import me.janta.example_mvp.adapters.ElementsAdapter;
import me.janta.example_mvp.models.Element;
import me.janta.example_mvp.presenters.MainPresenterImpl;
import me.janta.example_mvp.views.MainView;

public class MainActivity extends AppCompatActivity implements MainView {
    RecyclerView recyclerView;
    FloatingActionButton fab;
    MainPresenterImpl mainPresenter;
    ElementsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.listElements);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        setSupportActionBar(toolbar);
        getMainPresenter();
        mainPresenter.getElementsFromData();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addElement("Name", "Description");
                Snackbar.make(view, "Add new element correctly", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }


    @Override
    public void setElements(ArrayList<Element> elements) {

        adapter = new ElementsAdapter(elements, mainPresenter);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
    }

    @Override
    public void addElement(String name, String description) {
        mainPresenter.addElement(name, description);
        adapter.notifyDataSetChanged();
    }

    public MainPresenterImpl getMainPresenter() {
        mainPresenter = new MainPresenterImpl(this);
        return mainPresenter;
    }
}
