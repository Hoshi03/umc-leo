package leo.umc.web.controller;

import leo.umc.apiPayload.ApiResponse;
import leo.umc.converter.MemberConverter;
import leo.umc.domain.Member;
import leo.umc.service.MemberService.MemberCommandService;
import leo.umc.service.MemberService.MemberQueryService;
import leo.umc.web.dto.MemberRequestDTO;
import leo.umc.web.dto.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}