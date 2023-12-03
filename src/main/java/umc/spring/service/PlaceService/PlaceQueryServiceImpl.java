package umc.spring.service.PlaceService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.converter.PlaceConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Place;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.*;
import umc.spring.validation.annotation.CheckPage;

import java.util.Optional;

import static umc.spring.domain.enums.MissionStatus.ONGOING;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlaceQueryServiceImpl implements PlaceQueryService{

    private final PlaceRepository placeRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public Optional<Place> findStore(Long id) {
        return placeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Place store = placeRepository.findById(StoreId).get();

        Page<Review> placePage = reviewRepository.findAllByPlace(store, PageRequest.of(page, 10));
        return placePage;
    }

    @Override
    public Page<Review> getMyReviewList(@CheckPage Integer page) {
        User user = memberRepository.findById(1L).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Page<Review> reviewPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
        return reviewPage;
    }

    @Override
    public Page<Mission> getMissionList(Long StoreId, Integer page) {
        Place store = placeRepository.findById(StoreId).get();

        Page<Mission> missions = missionRepository.findAllByPlace(store, PageRequest.of(page, 10));
        return missions;
    }

    @Override
    public Page<UserMission> getMyMissionList(String missionStatus, @CheckPage Integer page) {
        User user = memberRepository.findById(1L).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Page<UserMission> usermissions = userMissionRepository.findAllByUserAndMissionStatus(user, MissionStatus.valueOf(missionStatus), PageRequest.of(page, 10));
        return usermissions;
    }
}
