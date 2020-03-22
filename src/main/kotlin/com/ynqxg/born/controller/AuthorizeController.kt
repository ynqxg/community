package com.ynqxg.born.controller

import com.ynqxg.born.dto.AccessTokenDTO
import com.ynqxg.born.provider.GiteeProvider
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AuthorizeController {

	@Autowired
	private lateinit var giteeProvider: GiteeProvider

	@GetMapping("/callback")
	fun callback(@RequestParam(name = "code") code: String): String {
		val accessTokenDTO = AccessTokenDTO(
				"authorization_code",
				code,
				"8a157607c219925999c8a115d578eb3d5436b16e7b4176d997fe143f4485c690",
				"http://localhost:8887/callback",
				"b676542be3161f1a004539d4b14925814ffc96f8e2d789cd2c738c1dd934a90e"
		)
		giteeProvider.getAccessToken(accessTokenDTO)
		return "index"
	}
}