package com.hk.com_ans_student.net

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class CookieReadInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val builder = chain.request().newBuilder()
        builder.addHeader("authorization","eyJhbGciOiJSUzI1NiJ9.eyJ1c2VySWQiOiIwIiwibmFtZSI6IuaWveaZk-WFiSIsIm1vYmlsZSI6IjEzOTExMDk0NzQ1IiwibWFuYWdlVXNlcklkIjoiVDAwMCIsImV4cCI6MTYxMzcyMjUzN30.H6DMZCZg1Hs1wRCX1fJAg_vF1VgOf-D9yJ25h_RYz8Cx3AfpDQ7lEofRoW0mmKaU-VSg3HcAMIxJiWtGeJrJRlO98M2Nbcq_xC3IR-YcZi6A9yUTGjHR94AGOVQwmwYjWGqFX8Mxx_4IIxGj5zrDPDJSWS3t6UGXRpvtD-xAhZo")
        return chain.proceed(builder.build())
    }
}