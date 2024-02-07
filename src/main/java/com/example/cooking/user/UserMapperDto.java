package com.example.cooking.user;


import com.example.cooking.common.service.GenericDtoMapper;
import com.example.cooking.user.dto.UserRegisterDto;
import com.example.cooking.user.dto.UserResponseDto;
import com.example.cooking.user.dto.UserUpdateDto;
import com.example.cooking.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapperDto extends GenericDtoMapper<User, UserRegisterDto, UserUpdateDto, UserResponseDto> {

    private final ModelMapper mapper;

    @Override
    public User toEntity(UserRegisterDto userRegisterDto) {
        return mapper.map(userRegisterDto, User.class);
    }

    @Override
    public UserResponseDto toResponseDto(User user) {
        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public void update(UserUpdateDto userUpdateDto, User user) {
        mapper.map(userUpdateDto, user);
    }

    @Override
    public UserRegisterDto toCreateDto(User user) {
        return mapper.map(user, UserRegisterDto.class);
    }
}
