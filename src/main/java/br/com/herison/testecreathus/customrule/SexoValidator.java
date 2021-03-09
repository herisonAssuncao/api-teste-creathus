package br.com.herison.testecreathus.customrule;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SexoValidator implements ConstraintValidator<SexoCustomRule, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.equals("F") || s.equals("M");
    }
}
