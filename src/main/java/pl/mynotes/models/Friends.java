package pl.mynotes.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "friends")
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<Note> notes;

    public Friends(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Friends() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }
}
