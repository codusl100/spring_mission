package umc.spring.service.MemberService;

import umc.spring.domain.User;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.List;

public interface MemberCommandService {
    public User joinMember(MemberRequestDTO.JoinDto request);

    public boolean existCategories(List<Long> values);
}
