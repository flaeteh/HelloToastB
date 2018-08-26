package com.root.hellotoastb.Retrofit

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface EmployeeInterface {

    //get list of employees
    @GET("http://sampleapi.us.openode.io/")
    fun getEmployees(): Observable<ListEmployee>

    //retrofit
    companion object {
        fun create(): EmployeeInterface {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://sampleapi.us.openode.io/")
                    .build()

            return retrofit.create(EmployeeInterface::class.java)
        }
    }
}