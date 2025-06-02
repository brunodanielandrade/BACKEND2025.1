package br.uniesp.si.techback.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class IespNascValidator implements ConstraintValidator<ApenasMaiorIdade, String> {

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext context) {
        if (Objects.nonNull(valor) && valor.contains("idade < 18")){
            return true; // @NotNull deve ser usado separadamente se necessário
        }
        return false;
    }
}