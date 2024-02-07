package com.example.cooking.user;

import com.example.cooking.common.service.GenericCrudService;
import com.example.cooking.user.dto.*;
import com.example.cooking.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class UserService extends GenericCrudService<User, Integer, UserRegisterDto, UserUpdateDto, UserPatchDto, UserResponseDto> implements UserDetailsService {

    private final UserRepository repository;
    private final Class<User> EntityClass = User.class;
    private final UserMapperDto mapper;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .orElseThrow(() -> new EntityNotFoundException("user is email not found"));
    }


    @Override
    protected User save(UserRegisterDto userRegisterDto) {
        User user = mapper.toEntity(userRegisterDto);

        if (user.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return repository.save(user);
        }
        throw new RuntimeException("confirm password failed");
    }

    public UserResponseDto login(UserLoginDto userLogin) {

        User user = repository.findByEmail(userLogin.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("user is email not found"));

        if (passwordEncoder.matches(userLogin.getPassword(), user.getPassword())) {
            return mapper.toResponseDto(user);
        }

        throw new RuntimeException("password failed");

    }

    @Override
    protected User updateEntity(UserUpdateDto userUpdateDto, User user) {
        return null;
    }

}
