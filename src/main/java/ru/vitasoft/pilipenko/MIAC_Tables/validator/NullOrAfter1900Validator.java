package ru.vitasoft.pilipenko.MIAC_Tables.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;


public class NullOrAfter1900Validator
        implements ConstraintValidator<NullOrAfter1900, LocalDateTime> {
    public final void initialize(final NullOrAfter1900Validator annotation) {}

    public final boolean isValid(final LocalDateTime value,
                                 final ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }
        else{
            LocalDateTime c = LocalDateTime.parse("1900-01-01T00:00:00");
            return value.isAfter(c);
        }

    }
}

