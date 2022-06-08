package br.com.tarefas.listadetarefas.dto;

import br.com.tarefas.listadetarefas.exception.validation.DateFormater;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskFormDto {

    @NotEmpty(message = "Name task is required")
    private String nameTask;

    @NotEmpty(message = "Description is required")
    private String description;

    @NotNull(message = "Data is required, format DD/MM/YYYY")
    @DateFormater
    private String dateTask;

}
