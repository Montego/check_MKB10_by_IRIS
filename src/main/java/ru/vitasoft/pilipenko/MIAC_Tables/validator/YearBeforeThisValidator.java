package ru.vitasoft.pilipenko.MIAC_Tables.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;


public class YearBeforeThisValidator
        implements ConstraintValidator<YearBeforeThis, Integer> {
    public final void initialize(final YearBeforeThisValidator annotation) {}

    public final boolean isValid(final Integer value,
                                 final ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }
        else{
            int thisYear = (Calendar.getInstance()).get(Calendar.YEAR);
            return value < thisYear;
        }

    }
}