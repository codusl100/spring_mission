package umc.spring.service.AdminService;

import umc.spring.web.dto.AdminRequestDTO;

public interface AdminCommandService {
    public void plusPlace(AdminRequestDTO.plusPlaceDTO request);
}
