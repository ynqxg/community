package com.ynqxg.born.provider

import com.alibaba.fastjson.JSON
import com.ynqxg.born.dto.AccessTokenDTO
import com.ynqxg.born.dto.GiteeUser
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.springframework.stereotype.Component


@Component
class GiteeProvider {
	private val mediaType: MediaType = "application/json; charset=utf-8".toMediaType();
	private val client = OkHttpClient()

	fun getAccessToken(accessTokenDTO: AccessTokenDTO): String {

		val body: RequestBody = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO))
//				.create(json, JSON)
		val request: Request = Request.Builder()
				.url("https://gitee.com/oauth/token")
				.post(body)
				.build()
		client.newCall(request).execute().use { response ->
			println(response.body)
			return response.body!!.string()
		}
	}

	fun getUser(accessToken: String): GiteeUser {
		val url = "https://gitee.com/v5/user?access_token=${accessToken}"
		val request = Request.Builder().url(url).build()
		val response = client.newCall(request).execute()
		val string = response.body.toString()
		return JSON.parseObject(string, GiteeUser::class.java)
	}
}