package com.example.awsproject.mapper;

import com.example.awsproject.dto.IUserDto;
import com.example.awsproject.model.IUser;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface UserMapper {



    @Mapping(target = "events", ignore = true)
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    IUserDto map(IUser user);

    @Mapping(target = "events", ignore = true)
    @InheritInverseConfiguration
    IUser map(IUserDto userDto);
}
