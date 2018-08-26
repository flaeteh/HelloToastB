package com.root.hellotoastb.TheRecyclerView

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserData : RealmObject() {
    /*var image: String = ""
    var name: String = ""
    var number: String = ""
    var address: String = ""
    var comment: String = ""*/

    /*constructor() {}

    constructor(image: String, name: String, number: String, address:String, comment: String) {
        this.image = image
        this.name = name
        this.number = number
        this.address = address
        this.comment = comment

    }
    */
    @PrimaryKey
    private var id: Long = 0
    var name: String = ""
    var number: String = ""

    /*fun setId(id: Long) {
        this.id = id
    }

    fun getId() : Long {
        return id
    }

    fun setName (name: String) {
        this.name =  name
    }

    fun getName () : String {
        return name
    }

    fun setNumber (number: String) {
        this.number = number
    }

    fun getNumber() : String {
        return number
    }*/


}