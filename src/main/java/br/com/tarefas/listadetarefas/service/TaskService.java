package br.com.tarefas.listadetarefas.service;

import br.com.tarefas.listadetarefas.dto.TaskDto;
import br.com.tarefas.listadetarefas.dto.TaskFormDto;
import br.com.tarefas.listadetarefas.dto.UpdateTaskStatusFormDto;
import br.com.tarefas.listadetarefas.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;

public interface TaskService {

    TaskDto saveTask(TaskFormDto taskFormDto) throws ParseException;

    Page<TaskDto> listAllTask(Pageable page);

    TaskDto findTaskById(Long id);

    TaskDto updateTask(Long id, TaskFormDto taskFormDto);

    TaskDto updateTaskStatus(Long id, UpdateTaskStatusFormDto updateTaskStatusFormDto);

    void updateCurrentStatus(Page<Task> taskPage);

    void deleteTask(Long id);
}
