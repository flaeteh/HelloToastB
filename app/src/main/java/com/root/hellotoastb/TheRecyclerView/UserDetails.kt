package com.root.hellotoastb.TheRecyclerView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.root.hellotoastb.R
import com.root.hellotoastb.Realm.user

class UserDetails : AppCompatActivity(), iUserClickListener {
    var detailName : TextView? = null
    var detailNumber : TextView? = null
    /*var detailImage : ImageView? = null //Glide
    var detailAddress: TextView? = null
    var detailComment : TextView? = null*/

    override fun onClick(user: user) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        /*//Glide
        detailImage = findViewById(R.id.imageView)
        var image = intent.getStringExtra("picture")
        Glide.with(this)
                .load(image)
                .apply(RequestOptions.circleCropTransform())
                .into(detailImage!!)*/



        detailName = findViewById(R.id.detailName)
        var name = intent.getStringExtra("name")
        detailName?.text = name

        detailNumber = findViewById(R.id.detailNumber)
        var number = intent.getStringExtra("number")
        detailNumber?.text = number

      /*  detailAddress = findViewById(R.id.detailAddress)
        var address = intent.getStringExtra("address")
        detailAddress?.text = address

        detailComment = findViewById(R.id.detailComment)
        var comment = intent.getStringExtra("comment")
        detailComment?.text = comment*/
    }
}
