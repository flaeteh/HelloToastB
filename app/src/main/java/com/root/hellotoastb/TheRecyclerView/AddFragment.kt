package com.root.hellotoastb.TheRecyclerView

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.DialogFragment
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import com.root.hellotoastb.R
import com.root.hellotoastb.Realm.user
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmException
import kotlinx.android.synthetic.main.activity_realm2.*
import kotlinx.android.synthetic.main.fragment_add.*
import org.jetbrains.anko.support.v4.toast


class AddFragment : DialogFragment(), AcceptListener {
    private var nameEditText: EditText? = null
    private var numEditText: EditText? = null
    lateinit var mRealm: Realm

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Realm.init(context)
        var config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)
        mRealm = Realm.getDefaultInstance()
        return inflater.inflate(R.layout.fragment_add, container)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //gets fields from view yung nasa xml id gagamitin
        nameEditText = view.findViewById(R.id.txt_your_name) as EditText
        numEditText = view.findViewById(R.id.txt_your_num) as EditText

        // Fetch arguments from bundle and set title
        val titlename = arguments!!.getString("name", "Enter Name")
        dialog.setTitle(titlename)
        val titlenum = arguments!!.getString("num", "Enter Number")
        dialog.setTitle(titlenum)

        // Show soft keyboard automatically and request focus to field
        nameEditText!!.requestFocus()
        numEditText!!.requestFocus()
        dialog.window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)

        buttonAccept.setOnClickListener {
            addUser()
            dismiss()
        }

        buttonCancel.setOnClickListener {
            dismiss()
        }
    }

    //static
    companion object {
        fun newInstance(title: String): AddFragment {
            val frag = AddFragment()
            val args = Bundle()
            args.putString("title", title)
            frag.arguments = args
            return frag
        }
    }

    fun addUser() {
        try {
            var u = user()//mRealm.createObject(user::class.java)
            u.setUname(nameEditText?.text.toString()!!)
            u.setUnum(numEditText?.text.toString()!!)

            mRealm.executeTransaction { realm ->
                realm.insert(u)
                acceptListen.onSubmit()
            }

        }
        catch (e: RealmException) {
            Log.d("Error", e.message)
        }
    }

    //validation
    fun validation () {

    }

    //initialize interface
    lateinit var acceptListen: AcceptListener
    fun setListener(accept: AcceptListener) {
        acceptListen = accept
    }

    override fun onSubmit() {
        //nothing here
    }
}