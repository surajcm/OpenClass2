package com.github.surajcm.classroom.user.repo

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint


@Entity
@Table(name = "member", uniqueConstraints = [UniqueConstraint(columnNames = ["email"])])
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "first_name")
    var firstName: String? = null

    @Column(name = "last_name")
    var lastName: String? = null
    var email: String? = null
    var password: String? = null

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    )
    var roles: Collection<Role>? = null

    constructor() {}
    constructor(
        firstName: String?, lastName: String?, email: String?,
        password: String?, roles: Collection<Role>?
    ) : super() {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.password = password
        this.roles = roles
    }

}
