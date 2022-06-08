package br.com.tarefas.listadetarefas.service;

import br.com.tarefas.listadetarefas.dto.TaskDto;
import br.com.tarefas.listadetarefas.dto.TaskFormDto;
import br.com.tarefas.listadetarefas.exception.BusinessException;
import br.com.tarefas.listadetarefas.model.Task;
import br.com.tarefas.listadetarefas.repository.TaskRepository;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Collectors;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TaskDto saveTask(TaskFormDto taskFormDto) throws ParseException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(taskFormDto.getDate(), format);
        Task task = repository.save(modelMapper.map(taskFormDto, Task.class));
        task.setDate(date);
        return modelMapper.map(task, TaskDto.class);
    }

    @Override
    public Page<TaskDto> listAllTask(Pageable page){
        Page<Task> tasks = this.repository.findAll(page);
        return new PageImpl<>(tasks.stream().map(task -> modelMapper.map(task, TaskDto.class)).collect(Collectors.toList()));
    }

    @Override
    public TaskDto findTaskById(Long id) throws BusinessException{
    return modelMapper.map(this.repository.findById(id).orElseThrow(() ->new BusinessException(404, "NOT_FOUND", "TASK NOT FOUND")), TaskDto.class);
    }

    @Override
    public TaskDto updateTask(Long id, TaskFormDto taskFormDto) throws BusinessException{
        Task task = repository.findById(id).orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "TASK NOT FOUND"));
        task.setNameTask(taskFormDto.getNameTask());
        task.setDescription(taskFormDto.getDescription());
        Task updated = this.repository.save(task);
        return modelMapper.map(updated, TaskDto.class);
    }

    @Override
    public void deleteTask(Long id) throws BusinessException{
        Task task = this.repository.findById(id).orElseThrow(() ->new BusinessException(404, "NOT_FOUND", "TASK NOT FOUND"));
        this.repository.delete(task);
    }
}
