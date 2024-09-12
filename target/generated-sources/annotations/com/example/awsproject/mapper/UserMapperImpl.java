package com.example.awsproject.mapper;

import com.example.awsproject.dto.IUserDto;
import com.example.awsproject.model.IUser;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-10T08:56:10+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public IUserDto map(IUser user) {
        if ( user == null ) {
            return null;
        }

        IUserDto.IUserDtoBuilder iUserDto = IUserDto.builder();

        iUserDto.id( user.getId() );
        iUserDto.status( user.getStatus() );
        iUserDto.username( user.getUsername() );
        iUserDto.firstName( user.getFirstName() );
        iUserDto.lastName( user.getLastName() );
        iUserDto.password( user.getPassword() );
        iUserDto.enabled( user.isEnabled() );
        iUserDto.role( user.getRole() );

        return iUserDto.build();
    }

    @Override
    public IUser map(IUserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        IUser.IUserBuilder iUser = IUser.builder();

        iUser.id( userDto.getId() );
        iUser.username( userDto.getUsername() );
        iUser.role( userDto.getRole() );
        iUser.firstName( userDto.getFirstName() );
        iUser.lastName( userDto.getLastName() );
        iUser.password( userDto.getPassword() );
        iUser.enabled( userDto.isEnabled() );
        iUser.status( userDto.getStatus() );

        return iUser.build();
    }
}
