package com.root.hellotoastb.RealmKotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.root.hellotoastb.R
import io.realm.Realm

class RealmActivity2 : AppCompatActivity() {
    internal var add: Button? = null
    internal var view: Button? = null
    internal var update: Button? = null
    internal var delete: Button? = null
    internal var roll_no: EditText? = null
    internal var name: EditText? = null
    internal var text: TextView? = null
    internal var realm: Realm? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm2)

        add = findViewById<Button>(R.id.add)
        view = findViewById<Button>(R.id.view)
        update = findViewById<Button>(R.id.update)
        delete = findViewById<Button>(R.id.delete)
        roll_no = findViewById<EditText>(R.id.roll_no)
        name = findViewById<EditText>(R.id.name)
        text = findViewById<TextView>(R.id.text)

        Realm.init(this)
        realm = Realm.getDefaultInstance()
    }

    fun clickAction(view: View) {
        when (view.id) {
            R.id.add -> addRecord()
            R.id.view -> viewRecord()
            R.id.update -> updateRecord()
            R.id.delete -> deleteRecord()
        }
    }

    fun addRecord() {
        realm!!.beginTransaction()

        var student = realm!!.createObject(Student::class.java)
        //student?.roll_no? = (roll_no?.text.toString())
        var num = student.roll_no?.toString()
        var num2 = num!!.toInt()

        if (student != null) {
            student.name = name?.text.toString()
        }

        realm!!.commitTransaction()
    }

    fun viewRecord() {
        val results = realm?.where(Student::class.java)!!.findAll()

        text!!.text = ""

        for (student in results) {
            text!!.append(student.roll_no.toString() + " " + student.name + "\n")
        }
    }

    fun updateRecord() {
        val results = realm?.where(Student::class.java)!!
                .equalTo("roll_no", Integer.parseInt(roll_no?.text.toString()))
                .findAll()

        realm!!.beginTransaction()

        for (student in results) {
            student.name = name?.text.toString()

        }

        realm!!.commitTransaction()
    }

    fun deleteRecord() {
        val results = realm?.where(Student::class.java)!!.equalTo("roll_no", Integer.parseInt(roll_no?.text.toString())).findAll()

        realm!!.beginTransaction()

        results.deleteAllFromRealm()

        realm!!.commitTransaction()
    }

    override fun onDestroy() {
        realm!!.close()
        super.onDestroy()
    }
}