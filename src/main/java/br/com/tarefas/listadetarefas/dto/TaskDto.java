package br.com.tarefas.listadetarefas.dto;

import br.com.tarefas.listadetarefas.constants.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private Long id;
    private String nameTask;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",locale = "pt-BR")
    private LocalDate dateTask;
    private Status status;
}
