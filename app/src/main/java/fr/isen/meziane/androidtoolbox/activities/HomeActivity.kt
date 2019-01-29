package fr.isen.meziane.androidtoolbox.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import fr.isen.meziane.androidtoolbox.R

import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    var mypreference = "mypref"
    var user = "userKey"
    var passw = "passKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)


        cycleDeVie.setOnClickListener(){
            val intent = Intent(this, LifeCycleActivity::class.java)
            startActivity(intent)
        }

        permissions.setOnClickListener(){
            val intent = Intent(this, PermissionsActivity::class.java)
            startActivity(intent)
        }

        download.setOnClickListener(){
            val intent = Intent(this, WebActivity::class.java)
            startActivity(intent)
        }

        sauvegarde.setOnClickListener(){
            val intent = Intent(this, SaveActivity::class.java)
            startActivity(intent)
        }

        disconnect.setOnClickListener(){
            val editor = sharedpreferences.edit()
            editor.putString(user, "")
            editor.putString(passw, "")
            editor.commit()
            Log.i("disconnect", "test")
            finish()
        }
    }

}
