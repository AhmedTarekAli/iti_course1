package com.a7med.iti_course1.network

import com.a7med.iti_course1.modle.ResponsDataList
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

@GET("api/users")
   suspend fun getUsers() :Response<ResponsDataList>
}