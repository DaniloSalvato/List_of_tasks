package br.com.tarefas.listadetarefas.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusinessException extends RuntimeException{

    private Integer status;
    private String error;
    private String message;

    public BusinessException(Integer status, String error, String message){
        super();
        this.status = status;
        this.error = error;
        this.message = message;
    }

}
