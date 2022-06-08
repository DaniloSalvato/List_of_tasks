package br.com.tarefas.listadetarefas.exception.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroFormDto {
    private String nome;
    private String error;

}