package umc.spring.converter;

import umc.spring.domain.mapping.ReviewPhoto;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewPhotoConverter {
    public static List<ReviewPhoto> toReviewPhoto(List<String> photoUrls){

        return photoUrls.stream()
                .map(photoUrl ->
                        ReviewPhoto.builder()
                                .photoUrl(photoUrl)
                                .build()
                ).collect(Collectors.toList());
    }
}
