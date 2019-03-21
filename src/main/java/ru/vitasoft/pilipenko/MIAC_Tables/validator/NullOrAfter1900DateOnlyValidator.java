package ru.vitasoft.pilipenko.MIAC_Tables.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class NullOrAfter1900DateOnlyValidator
        implements ConstraintValidator<NullOrAfter1900DateOnly, LocalDate> {
    public final void initialize(final NullOrAfter1900DateOnlyValidator annotation) {}

    public final boolean isValid(final LocalDate value,
                                 final ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }
        else{
            LocalDate c = LocalDate.parse("1900-01-01");
            return value.isAfter(c);
        }

    }
}
