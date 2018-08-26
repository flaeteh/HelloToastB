/*
package com.root.hellotoastb.RealmRecyclerView

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.root.hellotoastb.R
import com.root.hellotoastb.Realm.rrvUser
import io.realm.RealmBasedRecyclerViewAdapter
import io.realm.RealmResults
import io.realm.RealmViewHolder
import org.jetbrains.anko.image

class rrvAdapter(
        context: Context,
        realmResults: RealmResults<rrvUser>,
        automaticUpdate: Boolean,
        animateResults: Boolean) : RealmBasedRecyclerViewAdapter<rrvUser, rrvAdapter.ViewHolder>(context, realmResults, automaticUpdate, animateResults) {

    inner class ViewHolder(container: RelativeLayout) : RealmViewHolder(container) {

        var rrvImage: ImageView = container.findViewById(R.id.rrvImageView) as ImageView
        var rrvNameText: TextView = container.findViewById(R.id.rrv_name) as TextView
        var rrvNumText: TextView = container.findViewById(R.id.rrv_num) as TextView

    }

    override fun onCreateRealmViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = inflater.inflate(R.layout.rrv_user, viewGroup, false)
        return ViewHolder(v as RelativeLayout)
    }

    override fun onBindRealmViewHolder(viewHolder: ViewHolder, position: Int) {
        val rrvUser = realmResults[position]
        if (rrvUser != null) {
            //viewHolder.rrvImage.image = rrvUser?.get
            viewHolder.rrvNameText.text = rrvUser?.getRRVName()
            viewHolder.rrvNumText.text = rrvUser?.getRRVNum()
        }



    }
}*/
