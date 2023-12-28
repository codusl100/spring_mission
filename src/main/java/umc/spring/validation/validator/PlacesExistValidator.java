package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.PlaceService.PlaceQueryService;
import umc.spring.validation.annotation.ExistPlaces;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class PlacesExistValidator implements ConstraintValidator<ExistPlaces, Long> {

    private final PlaceQueryService placeQueryService;

    @Override
    public void initialize(ExistPlaces constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = placeQueryService.checkPlaces(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PLACE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
