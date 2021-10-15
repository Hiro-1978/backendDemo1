package com.spingboot.backendDemo1.mapper;

import com.spingboot.backendDemo1.entity.User;
import com.spingboot.backendDemo1.model.MRegisterResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    MRegisterResponse toRegisterResponse(User user);

}
