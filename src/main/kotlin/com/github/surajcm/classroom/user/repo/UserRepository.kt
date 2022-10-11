package com.github.surajcm.classroom.user.repo

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String?): User?
}