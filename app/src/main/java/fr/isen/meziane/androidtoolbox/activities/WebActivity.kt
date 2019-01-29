package fr.isen.meziane.androidtoolbox.activities

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import fr.isen.meziane.androidtoolbox.model.RandomUser
import fr.isen.meziane.androidtoolbox.model.Results
import kotlinx.android.synthetic.main.activity_web.*


class WebActivity : AppCompatActivity() {

    var names = ArrayList<String>()
    var address = ArrayList<String>()
    var mail = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(fr.isen.meziane.androidtoolbox.R.layout.activity_web)
        val gson = GsonBuilder().setPrettyPrinting().create()
        var randomuser : RandomUser = RandomUser()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(
                Manifest.permission.INTERNET
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.INTERNET),
                100
            )
        }else {
           // val textView = findViewById<TextView>(R.id.webstring)
            // ...

            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)
            val url = "https://randomuser.me/api/?results=50"

            // Request a string response from the provided URL.
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.

                    randomuser = gson.fromJson(response, RandomUser::class.java)
                    val list : ArrayList<Results> = ArrayList<Results>(randomuser.results)
                    val adapter = WebAdapter(list)
                    recyclerUser.layoutManager = LinearLayoutManager(applicationContext)
                    recyclerUser.itemAnimator = DefaultItemAnimator()
                    recyclerUser.adapter = adapter
                },
                Response.ErrorListener { //textView.text = "That didn't work!"
                     })

            // Add the request to the RequestQueue.
            queue.add(stringRequest)



        }
    }
}


