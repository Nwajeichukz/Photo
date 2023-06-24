package chuks.com.nwajei.services.authentication;

import chuks.com.nwajei.Entity.Role;
import chuks.com.nwajei.Entity.User;
import chuks.com.nwajei.Exception.ApiException;
import chuks.com.nwajei.dto.LoginDto;
import chuks.com.nwajei.dto.RegisterRequestDto;
import chuks.com.nwajei.dto.PictureAppResponse;
import chuks.com.nwajei.repo.RoleRepository;
import chuks.com.nwajei.repo.UserRepository;
import chuks.com.nwajei.services.JwtService;
import chuks.com.nwajei.services.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final MyUserDetailsService myUserDetailsService;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public PictureAppResponse<?> registerUser(RegisterRequestDto request) {
       boolean check = userRepository.existsByUsernameOrEmail(request.getUsername(), request.getEmail());

       if (check) throw new ApiException("User already exists, login to continue");

       User user = new User();
       user.setUsername(request.getUsername());
       user.setFirstname(request.getFirstname());
       user.setLastname(request.getLastname());
       user.setEmail(request.getEmail());

       if (!request.getPassword().equals(request.getConfirmPassword())){
           throw new ApiException("passwords do not corresponds");
       }

       user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role roles = roleRepository.findByName("USER").orElseThrow();
        user.setRoles(roles);

        userRepository.save(user);
        return new PictureAppResponse<>(0, "User Successfully Saved", Map.of(
                "id", user.getId(),
                "username", user.getUsername(),
                "email", user.getEmail()
        ));
    }

    public PictureAppResponse<?> registerAdmin(RegisterRequestDto request) {
        boolean check = userRepository.existsByUsernameOrEmail(request.getUsername(), request.getEmail());

        if (check) throw new ApiException("User already exists, login to continue");

        User user = new User();
        user.setUsername(request.getUsername());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());

        if (!request.getPassword().equals(request.getConfirmPassword())){
            throw new ApiException("passwords do not corresponds");
        }

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role roles = roleRepository.findByName("ADMIN").orElseThrow();
        user.setRoles(roles);

        userRepository.save(user);
        return new PictureAppResponse<>(0, "User Successfully Saved", Map.of(
                "id", user.getId(),
                "username", user.getUsername(),
                "email", user.getEmail()
        ));
    }

    public PictureAppResponse<?> login(LoginDto login){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword())
        );

        var user = myUserDetailsService.loadUserByUsername(login.getEmail());

        var jwtToken = jwtService.generateToken(user);

        return new PictureAppResponse<>(0, "Successfully logged in", jwtToken);
    }
}