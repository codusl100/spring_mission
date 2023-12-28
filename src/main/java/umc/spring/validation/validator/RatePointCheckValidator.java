package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.validation.annotation.CheckRatePoint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class RatePointCheckValidator implements ConstraintValidator<CheckRatePoint, Double> {
    @Override
    public void initialize(CheckRatePoint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        boolean isValid = value >= 1 && value <= 5;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REVIEW_RATEPOINT_BAD_REQUEST.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
