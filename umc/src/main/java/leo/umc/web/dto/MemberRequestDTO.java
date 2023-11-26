package leo.umc.web.dto;

import leo.umc.validation.annotation.ExistCategories;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String detailAddress;
        String phoneNum;
        String loginId;
        String password;
        String email;
        Integer point;
        @ExistCategories
        List<Long> preferCategory;
    }
}
