/*
package com.root.hellotoastb.RealmRecyclerView

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.root.hellotoastb.R
import com.root.hellotoastb.Realm.rrvUser

class RealmRVAdapter (private val context: Context, private val list: List<rrvUser>) : RecyclerView.Adapter<RealmRVViewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RealmRVViewholder {
        val layoutInflater = LayoutInflater.from(context)
        val myView = layoutInflater.inflate(R.id.rrv_user, parent, false)
        return RealmRVViewHolder(context, myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RealmRVViewholder, position: Int) {
        holder.bindDataToViewHolder (list[position], position)
    }


}
*/
