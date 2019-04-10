package com.venkatesh.schoolmanagement

import com.venkatesh.schoolmanagement.model.MaterialUpload
import com.venkatesh.schoolmanagement.model.SMSEvent
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url


interface RetrofitApiInteface {

    @GET("events.json")
    fun getEvents(): Call<List<SMSEvent>>?

    @GET("{api}.json")
    fun getClassMaterials(@Path("api") api: String): Call<List<MaterialUpload>>?

    @GET
    fun downloadFileWithDynamicUrlSync(@Url fileUrl: String): Call<ResponseBody>
}