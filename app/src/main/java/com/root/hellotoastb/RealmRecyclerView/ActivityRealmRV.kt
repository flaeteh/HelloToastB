/*
package com.root.hellotoastb.RealmRecyclerView

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView
import com.root.hellotoastb.Realm.rrvUser
import com.root.hellotoastb.R
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm_rv.*
import kotlinx.android.synthetic.main.rrv_user.*

class ActivityRealmRV : AppCompatActivity() {

    lateinit var realm : Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm_rv)

        var config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)
        realm = Realm.getDefaultInstance()

        val rrvUsers = realm
                .where(rrvUser::class.java)
                .equalTo("rrv_name", rrv_name.text.toString())
                .findAll()

        val rrvAdapter = rrvAdapter(this, rrvUsers, true, true)
        val realmRecyclerView = findViewById<RealmRecyclerView>(R.id.rrv_recycler_view)
        realmRecyclerView.setAdapter(rrvAdapter)


        //clicklistener
        fab.setOnClickListener {
            buildAndShowInputDialog()
        }
    }

    private fun buildAndShowInputDialog() {

        val builder = AlertDialog.Builder(this@ActivityRealmRV)
        builder.setTitle("CONTACTS")
        val li = LayoutInflater.from(this)
        val dialogView = li.inflate(R.layout.dialog_view, null)
        val inputNames = dialogView.findViewById(R.id.inputName) as EditText
        val inputNums = dialogView.findViewById(R.id.inputNumber) as EditText

        builder.setView(dialogView)
        builder.setPositiveButton("OK", object: DialogInterface.OnClickListener {
            override fun onClick(dialog:DialogInterface, which:Int) {
                addUsers(inputNames.text.toString(),inputNums.text.toString())

            }
        })

        builder.setNegativeButton("Cancel", object: DialogInterface.OnClickListener {
            override fun onClick(dialog:DialogInterface, which:Int) {
                dialog.cancel()
            }
        })

        val dialog = builder.show()
        inputNames.setOnEditorActionListener(
                TextView.OnEditorActionListener {
                    v, actionId, event ->
                    if ((actionId == EditorInfo.IME_ACTION_DONE || ((event.action === KeyEvent.ACTION_DOWN && event.keyCode === KeyEvent.KEYCODE_ENTER)))) {
                        dialog.dismiss()
                        addUsers(inputNames.text.toString(),inputNums.text.toString())

                        return@OnEditorActionListener true
                    }
                    false
                })
    }

     fun addUsers(rrv_name:String, rrv_num:String) {
        if (rrv_name == null || rrv_num == null)
        {
            Toast
                    .makeText(this, "You have no friends.", Toast.LENGTH_SHORT)
                    .show()
            return
        }

        realm.beginTransaction()
        val rrvUser = realm.createObject(rrvUser::class.java)
        rrvUser.setId(System.currentTimeMillis())
        rrvUser.setRRVName(rrv_name)
         rrvUser.setRRVNum(rrv_num)
        realm.commitTransaction()
    }


}

*/
