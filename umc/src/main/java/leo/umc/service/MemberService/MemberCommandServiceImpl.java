package leo.umc.service.MemberService;

import leo.umc.apiPayload.code.status.ErrorStatus;
import leo.umc.apiPayload.exception.handler.FoodCategoryHandler;
import leo.umc.converter.MemberConverter;
import leo.umc.converter.MemberPreferConverter;
import leo.umc.domain.FoodType;
import leo.umc.domain.Member;
import leo.umc.domain.mapping.MemberPrefer;
import leo.umc.repository.FoodTypeRepository;
import leo.umc.repository.MemberRepository;
import leo.umc.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodTypeRepository foodTypeRepository;
    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodType> foodTypeList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodTypeRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodTypeList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}