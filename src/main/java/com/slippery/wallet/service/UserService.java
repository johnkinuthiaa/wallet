package com.slippery.wallet.service;

import com.slippery.wallet.dto.UserDto;
import com.slippery.wallet.models.User;

public interface UserService {
    UserDto registerUser(User userDetails);
}
