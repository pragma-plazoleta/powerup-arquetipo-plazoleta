package com.pragma.powerup.infrastructure.feign;

import com.pragma.powerup.application.mapper.request.IUserMapper;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.IUserServicePort;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserServiceImpl  implements IUserServicePort {

    private final UserFeignClient userFeignClient;
    private final IUserMapper userMapper;

    public UserServiceImpl(UserFeignClient userFeignClient, IUserMapper userMapper) {
        this.userFeignClient = userFeignClient;
        this.userMapper = userMapper;
    }

    @Override
    public UserModel getUser(String id, Map<String, String> header) {
        return userMapper.toModel(userFeignClient.getUserById(id, header));
    }
}
