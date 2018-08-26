package com.root.hellotoastb.TheRecyclerView

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.root.hellotoastb.R
//import com.root.hellotoastb.Realm.RealmActivity
import com.root.hellotoastb.RealmKotlin.RealmActivity2
//import com.root.hellotoastb.RealmRecyclerView.ActivityRealmRV

import com.root.hellotoastb.Retrofit.RetroFitActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        theButton.setOnClickListener {
            val intent = Intent(this, TheListActivity::class.java)
            startActivity(intent)
        }

        retrofitButton.setOnClickListener {
            val intent = Intent(this, RetroFitActivity::class.java)
            startActivity(intent)
        }

        /*realmButton.setOnClickListener {
            val intent = Intent(this, RealmActivity::class.java)
            startActivity(intent)
        }*/

        realmButton2.setOnClickListener {
            val intent = Intent(this, RealmActivity2::class.java)
            startActivity(intent)
        }

      /*  buttonRealmRV.setOnClickListener {
            val intent = Intent(this, ActivityRealmRV::class.java)
            startActivity(intent)
        }*/


    }
}
