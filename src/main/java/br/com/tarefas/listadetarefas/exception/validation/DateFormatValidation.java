package br.com.tarefas.listadetarefas.exception.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateFormatValidation implements ConstraintValidator <DateFormater, String>{

    @Override
    public void initialize(DateFormater constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String datePattern = "^([0-2]\\d|(3)[0-1])(/)(((0)\\d)|((1)[0-2]))(/)\\d{4}$";

        return s.matches(datePattern);

    }
}
