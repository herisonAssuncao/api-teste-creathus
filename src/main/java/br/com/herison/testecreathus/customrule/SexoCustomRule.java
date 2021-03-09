package br.com.herison.testecreathus.customrule;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SexoValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface SexoCustomRule {
    String message() default "Sexo Inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
