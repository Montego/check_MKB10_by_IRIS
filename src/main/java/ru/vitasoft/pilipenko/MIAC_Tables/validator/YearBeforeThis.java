package ru.vitasoft.pilipenko.MIAC_Tables.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = YearBeforeThisValidator.class)
@Documented
public @interface YearBeforeThis {
    String message() default "Дополнительная валидация. Указанно число меньше 1900 и не NULL";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}