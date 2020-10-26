package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.example.myapplication.entity.getRequest.RequestGetModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity( ) {
    var list = RequestGetModel(null)
    var responseBody: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData(1)
    }

    fun initViews(){
        val numberOfColumns = 2
        tape.addItemDecoration(ItemOffsetDecoration(10))

        val adapter = FeedAdapter(Data.getItemsList(applicationContext))

        val gridLayoutManager = GridLayoutManager(this, numberOfColumns)
        gridLayoutManager.spanSizeLookup = object : SpanSizeLookup( ) {
            override fun getSpanSize(position: Int) = when (position % 3) {
                0 -> {
                    adapter.setSizeForm(position, ItemType.BIG_FORM)
                    2
                }
                else -> 1
            }

        }
        tape.layoutManager = gridLayoutManager
        tape.adapter = adapter
    }



    private fun getData(limit: Int) {
        //https://api.sport24.ru/mobile/v1/feed?limit=20
        val client = OkHttpClient( )
        val url = "https://api.sport24.ru/mobile/v1/feed?limit=$limit"

        val request: Request = Request.Builder( ).url(url).build( )
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                Log.d("MMV", "-----Fail-----")
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call?, response: Response) {
                if (!response.isSuccessful) {
                    throw IOException("Error response $response")
                } else {
                    Log.d("MMV", "-----Ok-----")
                }

                responseBody = response.body( )?.string( )
                list = Gson( ).fromJson<RequestGetModel>(responseBody, RequestGetModel::class.java)

                runOnUiThread {
                    try {
                        Log.d("MMV", responseBody!!)
                        initViews()
                    } catch (ioe: IOException) {
                        Log.d("MMV", "-----Error during get body-----")
                    }
                }
            }
        })
    }


}