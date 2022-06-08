package pl.mynotes.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "my_groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<Note> notes;

    public Group(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group() {
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
