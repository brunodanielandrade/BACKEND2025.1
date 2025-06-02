package br.uniesp.si.techback.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IespEmailValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ApenasMaiorIdade {
    String message() default "A idade não é aceita";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}