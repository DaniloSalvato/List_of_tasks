package br.com.tarefas.listadetarefas.repository;

import br.com.tarefas.listadetarefas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface TaskRepository extends JpaRepository <Task, Long> {}
