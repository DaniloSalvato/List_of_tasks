package br.com.tarefas.listadetarefas.dto;

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
    @NotNull(message = "Name task is required")
    private String nameTask;

    @NotEmpty(message = "Description is required")
    @NotNull(message = "Description is required")
    private String description;

    @NotEmpty(message = "Data is required, format DD/MM/YYYY")
    @NotNull(message = "Data is required, format DD/MM/YYYY")
    private String date;

}
