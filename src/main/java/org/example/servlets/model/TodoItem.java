package org.example.servlets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "todos")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "description")
    private String description;
}
