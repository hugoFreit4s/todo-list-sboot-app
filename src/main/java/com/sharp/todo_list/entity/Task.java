package com.sharp.todo_list.entity;

import com.sharp.todo_list.enums.TaskStatusENUM;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Table(name = "tasks")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Task extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(nullable = false, name = "author_id")
    private User author;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatusENUM status;
}