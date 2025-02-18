package com.example.backangular.mapper;



import com.example.backangular.dto.UserRegisterRequestDto;
import com.example.backangular.dto.UserRegisterResponseDto;
import com.example.backangular.dto.UserResponseDto;
import com.example.backangular.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "type", expression = "java(com.example.backangular.entity.UserType.USER)")
    User mapToUser(UserRegisterRequestDto dto);

    UserRegisterResponseDto mapToDto(User user);
    UserResponseDto userToDto(User user);
}
