package com.chvei.converters;

import com.chvei.domain.User;
import com.chvei.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        return  userDto;
    }

}
