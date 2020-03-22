package com.ynqxg.born.dto

data class AccessTokenDTO(
		val grant_type: String,
		val code: String,
		val client_id: String,
		val redirect_uri: String,
		val client_secret: String)



