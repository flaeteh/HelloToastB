package com.root.hellotoastb.RealmKotlin

import io.realm.RealmObject

open class Student : RealmObject() {
    var roll_no: Int? = 0
    var name: String? = null
}