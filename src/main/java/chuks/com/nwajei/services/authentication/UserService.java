package chuks.com.nwajei.services.authentication;

import chuks.com.nwajei.dto.LoginDto;
import chuks.com.nwajei.dto.PictureAppResponse;
import chuks.com.nwajei.dto.RegisterRequestDto;

public interface UserService {
    PictureAppResponse<?> registerUser(RegisterRequestDto request);
    PictureAppResponse<?> registerAdmin(RegisterRequestDto request);

    PictureAppResponse<?> login(LoginDto login);
}
