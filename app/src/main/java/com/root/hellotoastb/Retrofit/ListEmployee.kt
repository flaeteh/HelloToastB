package com.root.hellotoastb.Retrofit
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListEmployee {

    @SerializedName("employee")
    @Expose
    var employee: ArrayList<Employee>? = null
}
