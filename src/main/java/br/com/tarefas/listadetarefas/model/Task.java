package br.com.tarefas.listadetarefas.model;

import br.com.tarefas.listadetarefas.constants.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task{


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nameTask;

    @Column
    private String description;

    @Column
    private LocalDate dateTask;

    @Column
    private Status status = Status.TO_DO;
}

