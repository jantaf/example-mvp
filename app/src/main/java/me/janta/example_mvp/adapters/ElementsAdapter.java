package me.janta.example_mvp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import me.janta.example_mvp.R;
import me.janta.example_mvp.models.Element;
import me.janta.example_mvp.presenters.MainPresenterImpl;


public class ElementsAdapter extends RecyclerView.Adapter<ElementsAdapter.ElementViewHolder> {
    private ArrayList<Element> Elements;
    private MainPresenterImpl mainPresenter;

    public ElementsAdapter(ArrayList<Element> Elements, MainPresenterImpl mainPresenter) {
        this.Elements = Elements;
        this.mainPresenter = mainPresenter;
    }

    @Override
    public ElementViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_recycler, viewGroup, false);
        return new ElementViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ElementViewHolder ElementViewHolder, final int i) {
        final Element ev = Elements.get(i);

        ElementViewHolder.textViewName.setText(ev.getName());
        ElementViewHolder.textViewDescription.setText(ev.getDescription());
        ElementViewHolder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.getItemPosition(i);
                notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return Elements.size();
    }


    public class ElementViewHolder extends RecyclerView.ViewHolder {
        protected TextView textViewName;
        protected TextView textViewDescription;
        protected ImageButton buttonDelete;

        public ElementViewHolder(View v) {
            super(v);
            textViewName = (TextView) v.findViewById(R.id.text_name);
            textViewDescription = (TextView) v.findViewById(R.id.text_description);
            buttonDelete = (ImageButton) v.findViewById(R.id.button_delete);

        }
    }
}
