package com.root.hellotoastb.Realm

import io.realm.RealmObject

open class user : RealmObject() {

    lateinit var uName: String
    lateinit var uNum: String


    fun setUname (uName: String) {
        this.uName = uName
    }

    fun getUname() : String {
        return uName
    }

    fun setUnum (uNum: String) {
        this.uNum = uNum
    }

    fun getUnum() : String {
        return uNum
    }

    //constant
   /* companion object {
        const val userField = "uName"
    }*/
}