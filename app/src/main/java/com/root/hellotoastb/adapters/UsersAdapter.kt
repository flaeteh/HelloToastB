package com.root.hellotoastb.adapters
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.root.hellotoastb.R
import com.root.hellotoastb.Realm.user
import com.root.hellotoastb.TheRecyclerView.iUserClickListener

class UsersAdapter(private var items: List<user>, val iUserClickListener: iUserClickListener): RecyclerView.Adapter<UsersAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    fun updateUsers(newItems: List<user>) {
        items = newItems
        notifyDataSetChanged()
    }

    //class for holding the list
    private var context : Context? = null
    inner class ViewHolder(row: View): RecyclerView.ViewHolder (row), View.OnClickListener {

        //var imgUsers: ImageView? = null //Glide
        var txtName: TextView? = null
        var txtNum: TextView? = null

        init {
            itemView.setOnClickListener(this)
            this@UsersAdapter.iUserClickListener
           // this.imgUsers = row?. findViewById<ImageView>(R.id.imgUsers) //Glide
            this.txtName = row?.findViewById(R.id.txtName)
            this.txtNum = row?.findViewById(R.id.txtNum)

        }

         override fun onClick(p0: View?) {
            iUserClickListener.onClick(items[adapterPosition])
        }

    }

    //method for returning the view for each item sa list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.user_list_row, parent, false)
        context = itemView.context
        return ViewHolder(itemView)
    }

    //method for binding data

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var user = items[position]
        holder?.txtName?.text = user.uName
        holder?.txtNum?.text = user.uNum


        //Glide
        /*if (context != null && holder?.imgUsers != null) {
            Glide.with(context!!)
                    .load(UserData.image)
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder?.imgUsers!!)
        }*/

    }
}
