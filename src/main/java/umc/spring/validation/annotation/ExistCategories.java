package umc.spring.validation.annotation;

import umc.spring.validation.validator.CategoriesExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented // 사용자 정의 어노테이션
// CategoriesExistValidator 클래스를 통해 @ExistCategories가 붙은 대상 검증
@Constraint(validatedBy = CategoriesExistValidator.class) // 사용자가 validation을 커스텀 어노테이션을 통해 할 수 있도록 제공하는 어노테이션
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER }) // 어노테이션 적용 범위 지정
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 생명 주기
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
