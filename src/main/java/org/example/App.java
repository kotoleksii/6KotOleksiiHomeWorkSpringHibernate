package org.example;

import org.example.entities.Employee;
import org.example.entities.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Post.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

//        Post post = new Post("Developer");
//        Employee employee1 = new Employee("Oleksii", "Kot");
//        Employee employee2 = new Employee("Viktor", "Monakhov");
//        Employee employee3 = new Employee("Ostap", "Drozd");
//        post.addEmployee(employee1);
//        post.addEmployee(employee2);
//        post.addEmployee(employee3);

        Employee employee = new Employee("Oleksii", "Kot");

        Post post1 = new Post("Developer");
        Post post2 = new Post("UI/UX Designer");
        Post post3 = new Post("Glovo courier");

        employee.addPost(post1);
        employee.addPost(post2);
        employee.addPost(post3);

        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();

//        session.beginTransaction();
//        Post post = session.get(Post.class, 1);
//        session.delete(post);
//        session.getTransaction().commit();


    }
}
