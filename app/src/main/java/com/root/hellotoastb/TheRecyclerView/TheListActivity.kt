package com.root.hellotoastb.TheRecyclerView
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.root.hellotoastb.R
import com.root.hellotoastb.Realm.user
import com.root.hellotoastb.adapters.UsersAdapter
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm_rv.*

class TheListActivity : AppCompatActivity(), iUserClickListener, AcceptListener {
    lateinit var realm: Realm

    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_list)

        //Realm config
        Realm.init(this)
        var config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)
        realm = Realm.getDefaultInstance()

        //RECYCLERVIEW
        recyclerView = findViewById(R.id.recyclerView)
        mAdapter = UsersAdapter(ArrayList(viewUsers()), this)
        recyclerView?.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.adapter = mAdapter
        mAdapter.notifyDataSetChanged() //will reload the data only when the activity is changed so dapat magback button muna

        //will show the dialog when button is clicked
        fab.setOnClickListener {
            showEditDialog()
        }
    }

    //Click accept and the load user function will show the added user immediately
    override fun onSubmit() {
        loadUser()
    }

    //Click one user and another activity will show containing more details about the user
    override fun onClick(user: user) {
        val intent = Intent(this, UserDetails::class.java)
        /* intent.putExtra("picture", user.image)
         intent.putExtra("address", user.address)
         intent.putExtra("comment", user.comment)*/
        intent.putExtra("name", user.uName) //passes the saved data to the next activity
        intent.putExtra("number", user.uNum)
        startActivity(intent)
    }

    //global variable for the adapter
    lateinit var mAdapter: UsersAdapter

    //function to store the adapter so this will show again when clicking accept/submit
    private fun loadUser() {
        mAdapter.updateUsers(ArrayList(viewUsers()))
    }

    //gets all data stored in Realm
    private fun viewUsers () : List<user>? {
        var realmResults = realm.where(user::class.java).findAll()
        return realmResults
    }

    //function for showing the dialog
    private fun showEditDialog() {
        val fm = supportFragmentManager
        val editNameDialogFragment = AddFragment.newInstance("Edit your name")
        editNameDialogFragment.setListener(this)
        editNameDialogFragment.show(fm, "fragment_edit_name")
    }

    //OLD FILE - RECYCLERVIEW ACTIVITY
    /*private fun generateData(): ArrayList<user> {
      var result = ArrayList<user>()

      for (i in 0..0) {
            var user: UserData = UserData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRqjxmwBVd1UPLqxUBw1JfvnkWJtbHZrEgrW2T5Ze4w4YERqHekQ", "Michelle", "09178837315", "Makati City, Philippines", "Good afternoon. See you.")
            result.add(user)
            var user2: UserData = UserData("https://78.media.tumblr.com/cd46dbdddb809de541c37b68ff6ad38b/tumblr_nuygtawcQc1upz5mso1_250.jpg", "Robin", "09178331859", "Quezon City, Philippines", "Congratulations!")
            result.add(user2)
            var user3: UserData = UserData("https://vignette.wikia.nocookie.net/friends/images/d/dc/Monica-Friends.jpg/revision/latest/scale-to-width-down/229?cb=20171230023430", "Monica", "09164350987", "Muntinlupa City, Philippines", "Congratulations and thank you!")
            result.add(user3)
            var user4: UserData = UserData("https://i2.wp.com/www.screenspy.com/wp-content/uploads/2014/07/NUP_163671_0543.jpg?resize=300%2C336&ssl=1", "Harvey", "09363246734", "Taguig City, Philippines", "Are you alright?")
            result.add(user4)
            var user5: UserData = UserData("https://handymikan.com/wp-content/uploads/2017/11/%E3%83%AA%E3%83%83%E3%82%AF%EF%BC%97.jpg", "Louis", "09162651287", "Marikina City, Philippines", "See you later!")
            result.add(user5)
            var user6: UserData = UserData("https://pmctvline2.files.wordpress.com/2011/05/pdempsey_300110531122103.jpg?w=300&h=240", "Dempsey", "09061212986", "Las Pinas City, Philippines", "What happened?")
            result.add(user6)
            var user7: UserData = UserData("https://static.tvtropes.org/pmwiki/pub/images/5ad505e29b1fc223d35c3b5e6fa15192.png", "Donna", "09069875343", "Pasay City, Philippines", "I'll give him a call.")
            result.add(user7)
        }
        return result
    }*/
}
