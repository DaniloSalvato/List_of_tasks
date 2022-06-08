package br.com.tarefas.listadetarefas.controllers;

import br.com.tarefas.listadetarefas.dto.TaskDto;
import br.com.tarefas.listadetarefas.dto.TaskFormDto;
import br.com.tarefas.listadetarefas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.text.ParseException;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<TaskDto> saveTask(@RequestBody @Valid TaskFormDto taskFormDto) throws ParseException {
        return ResponseEntity.ok().body(service.saveTask(taskFormDto));
    }

    @GetMapping
    public ResponseEntity<Page<TaskDto>>listAllTask(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable page){
        return ResponseEntity.ok().body(service.listAllTask(page));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TaskDto>findTaskById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findTaskById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TaskDto>updateTask(@PathVariable Long id, @Valid @RequestBody TaskFormDto taskFormDto){
        return ResponseEntity.ok().body(service.updateTask(id,taskFormDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
    this.service.deleteTask(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
