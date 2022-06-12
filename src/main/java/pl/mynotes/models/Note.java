package pl.mynotes.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String type;

    @Column(length = 1000)
    private String checkType;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    @ManyToOne
    private User user;

    public Note(Long id, String title, String description, String type, String checkType, Folder folder, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.checkType = checkType;
        this.folder = folder;
        this.user = user;
    }

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", description = '" + description + '\'' +
                '}';
    }
}
