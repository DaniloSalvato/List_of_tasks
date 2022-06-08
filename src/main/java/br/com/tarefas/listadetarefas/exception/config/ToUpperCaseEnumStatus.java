package br.com.tarefas.listadetarefas.exception.config;

import br.com.tarefas.listadetarefas.constants.Status;
import org.springframework.core.convert.converter.Converter;

public class ToUpperCaseEnumStatus implements Converter<String,Status> {

    @Override
    public Status convert(String value){
        return Status.valueOf(value.toUpperCase());
    }
}
