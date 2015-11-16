package me.janta.example_mvp.models;

/**
 * Created by Jorge on 30/10/15.
 */
public class Element {
    private String Name;
    private String Description;

    public Element(String name, String description) {
        Description = description;
        Name = name;
    }

    public Element() {
        this.Description = "Description";
        this.Name = "Name";
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
