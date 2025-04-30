package com.pragma.powerup.infrastructure.feign;

import com.pragma.powerup.application.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "user-service", url = "${user-service.url}")
public interface UserFeignClient {

    @GetMapping("/{getUser}")
    UserResponseDto getUserById(@RequestParam("id") String id, @RequestHeader Map<String, String> header);
}
