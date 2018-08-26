package com.root.hellotoastb.Realm
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.root.hellotoastb.R
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import io.realm.exceptions.RealmException
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var enUser: EditText
    private lateinit var enNum: EditText
    lateinit var enNumber: EditText
    lateinit var realm : Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)
        //GETS VALUES FROM EDITTEXT
        enUser = findViewById<EditText>(R.id.editName)
        enNum = findViewById<EditText>(R.id.editNumber)
        enNumber = findViewById<EditText>(R.id.editNumber2)

        //REALM CONFIGURATION
        Realm.init(this)
        var config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)
        realm = Realm.getDefaultInstance()
        init()
    }

    //ONCLICK
    fun init(){
        addButton.setOnClickListener(this)
        viewButton .setOnClickListener(this)
        viewButton2 .setOnClickListener(this)
        updateButton .setOnClickListener(this)
        deleteButton .setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            addButton -> {
                addUser()
            }
            viewButton -> {
                viewUsers()
            }
            viewButton2 -> {
                viewUser()
            }
            updateButton -> {
                updateUser()
            }
            deleteButton -> {
                deleteUser()
            }
        }

    }

    //FUNCTION FOR ADDING USER
    fun addUser () {
        realm.beginTransaction()
        try {
            var nextId: Long = realm.where(user::class.java).count() + 1
            var u = realm.createObject(user::class.java,nextId)
             u.setUname(enUser.text.toString())
            u.setUnum(enNum.text.toString())


            realm.commitTransaction()
            showToast("User Added Successfully")
        }
        catch (e: RealmException) {
            Log.d("Tag",e.message)
        }
    }

    //FUNCTIONS FOR VIEW USERS
    fun viewUsers () : MutableList<user>{
        var realmResults = realm.where(user::class.java).findAll()
        var k = ""
    for (i in 0..realmResults.size-1)
        {
         //   var id: Long = realmResults.get(i)!!.getId()
            var user: String = realmResults.get(i)!!.getUname()
            var num: String = realmResults.get(i)!!.getUnum()
            k += "$user $num \n"

        }

        //showToast("$k")
        return realmResults
    }

    fun viewUser () {
        var realmResults = realm.where(user::class.java).contains("uName", enNumber.text.toString()).findAll()
        var k = ""
 for (i in 0..realmResults.size-1)
        {
          //  var id: Long = realmResults.get(i)!!.getId()
            var user: String = realmResults.get(i)!!.getUname()
            var num: String = realmResults.get(i)!!.getUnum()
            k += "$user $num \n"
        }

        showToast("$k")
    }

    fun updateUser () {
        try {
            realm.executeTransaction {
                 realm ->
                    var u: RealmResults<user>? = realm!!.where(user::class.java)!!
                            .equalTo("uNum", enNum?.text.toString())
                            //.equalTo(user.userField, enNum?.text.toString())
                            .findAll()

                    for (user in u!!) {
                        user.uName = enUser?.text.toString()
                        Log.e("updateUser", user.uName)
                    }

                    //u.setUname("Friend")
                    showToast("User Updated Successfully!")
                    //Log.e("")
                }

        }
        catch (ex: Exception) {
            Log.e("Error", ex.toString())
        }
    }

    fun deleteUser () {
        var results: RealmResults<user> = realm!!.where(user::class.java)
                .equalTo("uName", enUser?.text.toString())
                .findAll()
        realm.executeTransaction{
                results.deleteAllFromRealm()
                showToast("User Deleted Successfully!")

        }

    }

    override fun onDestroy() {
        realm!!.close()
        super.onDestroy()
    }

    fun showToast(s : String) {
        Toast.makeText(applicationContext,s,Toast.LENGTH_LONG).show()
    }

}
