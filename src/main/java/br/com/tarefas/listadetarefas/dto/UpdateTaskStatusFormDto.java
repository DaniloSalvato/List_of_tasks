package br.com.tarefas.listadetarefas.dto;

import br.com.tarefas.listadetarefas.constants.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskStatusFormDto {

    private Status status;
}
