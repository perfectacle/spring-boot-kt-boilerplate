package com.example.demo

import javax.servlet.http.HttpServletRequest

private const val X_FORWARDED_FOR = "X-FORWARDED-FOR"

fun getIp(request: HttpServletRequest): String {
    return request.getHeader(X_FORWARDED_FOR)?.split(" ")?.first() ?: request.remoteAddr ?: ""
}