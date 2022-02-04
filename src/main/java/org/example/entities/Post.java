package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;

    @ManyToMany(cascade = {
                    CascadeType.PERSIST,
                CascadeType.MERGE,
            CascadeType.DETACH,
        CascadeType.REFRESH
    })
    @JoinTable(
            name = "employees_posts",
            joinColumns = @JoinColumn(name =  "post_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;

    public Post(String title) {
        this.title = title;
    }

    public Post() {
    }

    public void addEmployee(Employee employee) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
