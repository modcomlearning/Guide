package com.lit.guide

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.gson.GsonBuilder
import com.lit.guide.adapters.LabAdapter
import com.lit.guide.helpers.ApiHelper
import com.lit.guide.models.Lab
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var itemList: List<Lab>
    lateinit var labAdapter: LabAdapter
    lateinit var progressbar: ProgressBar
    lateinit var recyclerView: RecyclerView
    lateinit var swiprrefresh: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler)
        progressbar= findViewById(R.id.progressbar)
        progressbar.visibility = View.VISIBLE

        labAdapter = LabAdapter(applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setHasFixedSize(true)


        //Request
        request()

        //====SEARCH======
        val edLabSearch = findViewById<EditText>(R.id.edLabSearch)
        edLabSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                filter(s.toString())
            }
        })
        //=====REFRESH=====
        swiprrefresh = findViewById<SwipeRefreshLayout>(R.id.swiperefresh)
        swiprrefresh.setOnRefreshListener {
             request()
        }

    }


    fun request(){
        val api = "https://modcom.pythonanywhere.com/api/laboratories"
        //Access the Helper
        val helper = ApiHelper(applicationContext)
        helper.get(api, object : ApiHelper.CallBack{
            override fun onSuccess(result: JSONArray?) {
                val gson = GsonBuilder().create()

                itemList  = gson.fromJson(result.toString(),
                    Array<Lab>::class.java).toList()

                //now pass the converted list to adapter
                labAdapter.setProductListItems(itemList)
                progressbar.visibility = View.GONE
                //now put the adapter to recycler view
                recyclerView.adapter = labAdapter
                swiprrefresh.isRefreshing = false
            }

            override fun onSuccess(result: JSONObject?) {
              //None
            }
            override fun onFailure(result: String?) {
              //None
            }
        })
    }

    //Filter
    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<Lab> = ArrayList()

        // running a for loop to compare elements.

        for (item in itemList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.lab_name.lowercase().contains(text.lowercase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            //Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
            labAdapter.filterList(filteredlist)
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            labAdapter.filterList(filteredlist)
        }
    }
}
