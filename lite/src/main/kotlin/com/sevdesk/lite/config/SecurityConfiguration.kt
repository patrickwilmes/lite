package com.sevdesk.lite.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager

/*
In order to secure the application from unauthorized third parties,
we are simply activating web and method security. To keep it simple
for this task, we are handling all of it in memory.

We define two users, jane and john, with different roles:
USER: is allowed to read and write invoices
VIEWER: is only allowed to read invoices

A user must submit a request with basic auth (web security), and will then be checked
by the assigned role, if he / she is allowed to access the function / resource (authorization,
method security).

In a more real world szenario, one would use a IAM platform like keycloak to implement
an OAuth2 workflow:
The user opens up the web application (or other frontend), and will be redirected to a
login page. The user credentials (username, password), will then be exchanged to a token (JWT),
which encodes also scope and user information. This token is returned to the frontend, which
will use the token to access the api's. On the backend side, a service would use for example
keycloak to verify the token. It could also use the token to check if the user requesting
access to a resource is permitted to use the resource.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfiguration {

    @Bean
    fun userDetailsService(): InMemoryUserDetailsManager {
        val johnDoe = User
            .withDefaultPasswordEncoder()
            .username("john")
            .password("doe")
            .roles("VIEWER")
            .build()
        val janeDoe = User
            .withDefaultPasswordEncoder()
            .username("jane")
            .password("doe")
            .roles("USER")
            .build()
        return InMemoryUserDetailsManager(listOf(johnDoe, janeDoe))
    }
}
