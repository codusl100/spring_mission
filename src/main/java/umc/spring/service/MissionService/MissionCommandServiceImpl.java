package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.PlaceHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.ReviewPhotoConverter;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.ReviewPhoto;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.PlaceRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.UserMissionRepository;
import umc.spring.web.dto.MissionRequestDTO;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final PlaceRepository placeRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    @Transactional
    public Review writeReview(MissionRequestDTO.writeReviewDTO request){
        Review newReview = ReviewConverter.toAddReview(request);
        newReview.setUser(memberRepository.findById(1L).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)));
        newReview.setPlace(placeRepository.findById(request.getPlaceId()).orElseThrow(() -> new PlaceHandler(ErrorStatus.PLACE_NOT_FOUND)));
        List<ReviewPhoto> reviewPhotos = ReviewPhotoConverter.toReviewPhoto(request.getPhotoUrl());
        reviewPhotos.forEach(photo -> {photo.setReview(newReview);});
        return reviewRepository.save(newReview);
    }

    @Override
    @Transactional
    public boolean checkMissionStatus(UserMission usermission){
        return userMissionRepository.findById(usermission.getId()).isEmpty();
    }
}
