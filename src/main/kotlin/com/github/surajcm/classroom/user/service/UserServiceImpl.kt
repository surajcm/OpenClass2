package com.github.surajcm.classroom.user.service

import com.github.surajcm.classroom.user.model.UserRegistrationDto
import com.github.surajcm.classroom.user.repo.Role
import com.github.surajcm.classroom.user.repo.User
import com.github.surajcm.classroom.user.repo.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Function
import java.util.stream.Collectors

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    private val log = LoggerFactory.getLogger(javaClass)
    @Autowired
    private val passwordEncoder: BCryptPasswordEncoder? = null

    override fun save(registrationDto: UserRegistrationDto?): User? {
        val user = User(
            registrationDto!!.firstName,
            registrationDto.lastName, registrationDto.email,
            passwordEncoder!!.encode(registrationDto.password),
            Arrays.asList(Role("ROLE_USER"))
        )
        return userRepository.save(user)
    }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        log.info("check for user !!!")
        var sz = userRepository.findAll().size;
        log.info("size is"+sz)
        //var everything = userRepository.findAll();
        //log.info("email is"+everything.get(0).email);
        //log.info("psw is"+everything.get(0).password);
        val user = userRepository.findByEmail(username)
            ?: throw UsernameNotFoundException("Invalid username or password.")
        log.info("user found !!!")
        log.info("psw is" +user.password)
        return org.springframework.security.core.userdetails.User(
            user.email, user.password,
            mapRolesToAuthorities(user.roles!!)
        )
    }

    private fun mapRolesToAuthorities(roles: Collection<Role>): Collection<GrantedAuthority?> {
        return roles.stream().map(Function<Role, SimpleGrantedAuthority?> { role: Role ->
            SimpleGrantedAuthority(
                role.name
            )
        }).collect(Collectors.toList())
    }

    override val all: List<User?>?
        get() = userRepository.findAll()

}