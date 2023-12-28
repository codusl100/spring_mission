package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.validation.annotation.LimitReviewPhoto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewPhotoLimitValidator implements ConstraintValidator<LimitReviewPhoto, List<String>> {
    @Override
    public void initialize(LimitReviewPhoto constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<String> values, ConstraintValidatorContext context) {
        boolean isValid = values.size() <= 3;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REVIEW_PHOTO_SIZE_BAD_REQUEST.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
