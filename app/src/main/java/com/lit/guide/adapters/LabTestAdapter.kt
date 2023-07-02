package com.lit.guide.adapters
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.lit.guide.R
import com.lit.guide.models.Lab
import com.lit.guide.models.LabTests

class LabTestAdapter(var context: Context)://When you want to toast smthg without intent or activities
    RecyclerView.Adapter<LabTestAdapter.ViewHolder>(){
    //View holder holds the views in single item.xml

    var itemList : List<LabTests> = listOf() // empty product list
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
    //Note below code returns above class and pass the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lab_tests, parent, false)
        return ViewHolder(view)
    }
    //so far item view is same as single item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val test_name = holder.itemView.findViewById(R.id.test_name) as TextView
        val test_description = holder.itemView.findViewById(R.id.test_desc) as TextView
        val test_cost = holder.itemView.findViewById(R.id.test_cost) as TextView
        //bind
        val item = itemList[position]
        test_name.text = item.test_name
        test_description.text = item.test_description
        test_cost.text = item.test_cost


//        holder.itemView.setOnClickListener {
//            val prefs: SharedPreferences = context.getSharedPreferences(
//                "store",
//                Context.MODE_PRIVATE
//            )
//
//            val editor: SharedPreferences.Editor = prefs.edit()
//            editor.putString("product_name", item.book_name)
//            editor.putString("product_desc", item.book_desc)
//            editor.putString("product_cost", item.book_publisher)
//            editor.putString("image_url", item.book_image)
//            editor.putString("book_id", item.book_id)
//            editor.apply()
//
//            val i = Intent(context, SingleActivity::class.java)
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            context.startActivity(i)
//
//        }

    }


    // method for filtering our recyclerview items.
    fun filterList(filterlist: ArrayList<LabTests>) {
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
    fun setProductListItems(itemList: List<LabTests>){
        this.itemList = itemList
        notifyDataSetChanged()
    }
}//end class
