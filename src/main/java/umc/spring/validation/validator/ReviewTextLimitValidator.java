package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.validation.annotation.LimitReviewText;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class ReviewTextLimitValidator implements ConstraintValidator<LimitReviewText, String> {
    @Override
    public void initialize(LimitReviewText constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = value.length() >= 10 && value.length() <= 300;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REVIEW_TEXT_LENGTH_BAD_REQUEST.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
