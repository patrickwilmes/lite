package com.sevdesk.lite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class LiteApplication {

    @Bean
    fun corsConfigurer(): WebMvcConfigurer? {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**")
                    .allowedOrigins("http://localhost:5173")
                    .allowedMethods(
                        HttpMethod.HEAD.name,
                        HttpMethod.GET.name,
                        HttpMethod.POST.name,
                        HttpMethod.PUT.name,
                        HttpMethod.DELETE.name,
                        HttpMethod.PATCH.name
                    )
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<LiteApplication>(*args)
}
