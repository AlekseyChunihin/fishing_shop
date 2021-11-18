package ua.com.alevel.fishing_shop.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String value;

    @ManyToMany(mappedBy = "authorities")
    @SuppressWarnings("FieldMayBeFinal")
    private Set<User> users = new HashSet<>();

    public Authority() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
