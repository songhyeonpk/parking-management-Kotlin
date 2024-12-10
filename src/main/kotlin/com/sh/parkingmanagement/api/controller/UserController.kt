package com.sh.parkingmanagement.api.controller

import com.sh.parkingmanagement.api.docs.UserApiSpec
import com.sh.parkingmanagement.core.domain.user.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) : UserApiSpec {

}