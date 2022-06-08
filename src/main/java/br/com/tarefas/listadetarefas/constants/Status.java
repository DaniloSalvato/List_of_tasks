package br.com.tarefas.listadetarefas.constants;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {
    TO_DO("to_do"),
    DONE("done"),
    NOT_DONE("not_done");

    Status(String value) {
        this.value = value;
    }

    private String value;

    @JsonCreator
    public static Status fromValue(String value) {
        for (Status status : Status.values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new RuntimeException("invalid option, you can use Done and Not_done");
    }
}
