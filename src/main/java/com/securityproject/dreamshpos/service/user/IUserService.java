package com.securityproject.dreamshpos.service.user;

import com.securityproject.dreamshpos.dto.UserDto;
import com.securityproject.dreamshpos.model.User;
import com.securityproject.dreamshpos.request.CreateUserRequest;
import com.securityproject.dreamshpos.request.UserUpdateRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);

    User getAuthenticatedUser();
}
