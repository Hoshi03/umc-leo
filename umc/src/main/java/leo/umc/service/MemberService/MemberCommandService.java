package leo.umc.service.MemberService;

import leo.umc.domain.Member;
import leo.umc.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
