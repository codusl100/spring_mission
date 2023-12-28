package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        LocalDate birthDate;
        @Size(min = 5, max = 20)
        String address;
        @ExistCategories
        List<Long> preferCategory;
    }
}
