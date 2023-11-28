package umc.spring.service.HomeCommandService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.UserMissionRepository;
import umc.spring.validation.annotation.CheckMissionStatus;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class HomeCommandServiceImpl implements HomeCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    @Transactional
    @CheckMissionStatus
    public UserMission challengeMission(Long missionId){
        User user = memberRepository.findById(1L).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        UserMission userMission = MissionConverter.toAddUserMission(mission);
        userMission.setUser(user);
        return userMissionRepository.save(userMission);
    }
}
