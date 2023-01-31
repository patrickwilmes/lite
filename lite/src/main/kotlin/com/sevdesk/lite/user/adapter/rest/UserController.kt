package com.sevdesk.lite.user.adapter.rest

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
@Validated
class UserController {

    @GetMapping("/{id}")
    fun getAllInvoices(
        @PathVariable("id") id: Int
    ): List<String> {
        if (id == 5) {
            return listOf("USER", "ADMIN")
        }

        return listOf("USER")
    }
}
