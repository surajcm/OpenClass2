package com.github.surajcm.classroom.user.web

import com.github.surajcm.classroom.user.model.UserRegistrationDto
import com.github.surajcm.classroom.user.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/registration")
class RegistrationController(private val userService: UserService) {
    @ModelAttribute("user")
    fun userRegistrationDto(): UserRegistrationDto {
        return UserRegistrationDto()
    }

    @GetMapping
    fun showRegistrationForm(): String {
        return "registration"
    }

    @PostMapping
    fun registerUserAccount(@ModelAttribute("user") registrationDto: UserRegistrationDto?): String {
        userService.save(registrationDto)
        return "redirect:/registration?success"
    }
}