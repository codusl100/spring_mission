package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.CheckMissionStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MissionCheckValidator implements ConstraintValidator<CheckMissionStatus, UserMission> {
    private final MissionCommandService missionCommandService;
    @Override
    public void initialize(CheckMissionStatus constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserMission value, ConstraintValidatorContext context) {
        boolean isValid = missionCommandService.checkMissionStatus(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_STATUS_BAD_REQUEST.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
