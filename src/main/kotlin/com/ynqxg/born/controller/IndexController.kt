package com.ynqxg.born.controller

import okhttp3.OkHttpClient
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import sun.net.www.http.HttpClient

@Controller
class IndexController {


    @GetMapping("/index")
    fun index(): String {
        return "index"
    }

}