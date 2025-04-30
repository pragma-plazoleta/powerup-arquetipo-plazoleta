package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.UserModel;

import java.util.Map;

public interface IUserServicePort {

    UserModel getUser(String id, Map<String, String> header);

}
