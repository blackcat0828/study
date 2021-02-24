package org.example.para.controller

import org.example.para.common.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/api/vv/hello")
    fun hello() = ApiResponse.ok("world")


    @GetMapping("/hello")
    fun hello2(): String {
        return "hello"
    }
}