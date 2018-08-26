package com.root.hellotoastb.Retrofit
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Employee {

    @SerializedName("employee_id")
    @Expose
    val employeeId: Long? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("birthday")
    @Expose
    var birthday: String? = null
    @SerializedName("job")
    @Expose
    var job: String? = null
    @SerializedName("contact")
    @Expose
    var contact: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("salary")
    @Expose
    var salary: String? = null
}


