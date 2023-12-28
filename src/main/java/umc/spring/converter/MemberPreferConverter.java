package umc.spring.converter;

import umc.spring.domain.FoodType;
import umc.spring.domain.mapping.UserFood;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<UserFood> toMemberPreferList(List<FoodType> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserFood.builder()
                                .foodType(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }

}
