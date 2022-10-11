package com.github.surajcm.classroom.user.service

import com.github.surajcm.classroom.user.model.UserRegistrationDto
import com.github.surajcm.classroom.user.repo.User
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService {
    fun save(registrationDto: UserRegistrationDto?): User?
    val all: List<User?>?
}