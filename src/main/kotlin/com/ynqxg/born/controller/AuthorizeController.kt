package com.ynqxg.born.controller

import okhttp3.OkHttpClient
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AuthorizeController {

    @GetMapping("/callback")
    fun callback(@RequestParam(name = "code") code:String): String {
        println(code)
        val okHttpClient = OkHttpClient()
        return "index"
    }
}