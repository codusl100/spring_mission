package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    Page<UserMission> findAllByUserAndMissionStatus(User user, MissionStatus missionStatus, PageRequest pageRequest);

    Optional<UserMission> findByMissionAndUserAndMissionStatus(Mission mission, User user, MissionStatus missionStatus);
}
