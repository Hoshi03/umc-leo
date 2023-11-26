package leo.umc.converter;

import leo.umc.domain.FoodType;
import leo.umc.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodType> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodType ->
                        MemberPrefer.builder()
                                .foodType(foodType)
                                .build()
                ).collect(Collectors.toList());
    }
}
