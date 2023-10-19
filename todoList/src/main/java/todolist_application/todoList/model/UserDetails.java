package todolist_application.todoList.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long userId;
    @Column(nullable=false)
    String firstName;
    @Column(nullable=false)
    String lastName;
    @Column(nullable=false)
    String email;
    @Column(nullable=false)
    String password;
    @Column(nullable=false)
    String phoneNumber;
    @Column(nullable=false)
    String gender;
    @Column(nullable=false)
    String role="user";
    @OneToMany(targetEntity = TodoList.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName ="userId")
    @JsonIgnoreProperties("UserDetails")
    private List<TodoList> todoList;
}
