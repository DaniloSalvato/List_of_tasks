package br.com.tarefas.listadetarefas.exception.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateFormatValidation.class)
public @interface DateFormater {

    String message() default "Invalid date, correct format is dd/MM/yyyy";
    Class<?>[] groups() default {};

    public abstract Class<? extends Payload>[] payload() default {};
}
