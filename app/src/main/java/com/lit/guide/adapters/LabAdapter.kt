package com.lit.guide.adapters
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lit.guide.LabTestsActivity

import com.lit.guide.R
import com.lit.guide.helpers.PrefsHelper
import com.lit.guide.models.Lab

class LabAdapter(var context: Context)://When you want to toast smthg without intent or activities
    RecyclerView.Adapter<LabAdapter.ViewHolder>(){
    //View holder holds the views in single item.xml

    var itemList : List<Lab> = listOf() // empty product list
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
    //Note below code returns above class and pass the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_labs, parent, false)
        return ViewHolder(view)
    }
    //so far item view is same as single item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lab_name = holder.itemView.findViewById(R.id.lab_name) as TextView
        val permit_id = holder.itemView.findViewById(R.id.permit_id) as TextView
        val email = holder.itemView.findViewById(R.id.email) as TextView
        //bind
        val item = itemList[position]
        lab_name.text = item.lab_name
        permit_id.text = item.permit_id
        email.text = item.email

        holder.itemView.setOnClickListener {
            PrefsHelper.saveprefs(context, "lab_id", item.lab_id)
            //Navigate to SingleACtivity, Created Earlier
            val i = Intent(context, LabTestsActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }

    }


    // method for filtering our recyclerview items.
    fun filterList(filterlist: ArrayList<Lab>) {
        // below line is to add our filtered
        // list in our course array list.
        itemList = filterlist
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    //we will call this function on Loopj response
    fun setProductListItems(productList: List<Lab>){
        this.itemList = productList
        notifyDataSetChanged()
    }
}//end class
