package fr.isen.meziane.androidtoolbox.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.*
import fr.isen.meziane.androidtoolbox.R

import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    var mypreference = "mypref"
    var user = "userKey"
    var passw = "passKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)
        sign_in_button.setOnClickListener {
            if( verifpass( password.text.toString()) == true && verifmail(email.text.toString()) == true){
                val editor = sharedpreferences.edit()
                editor.putString(user, email.text.toString())
                editor.putString(passw, password.text.toString())
                editor.commit()

                Toast.makeText(this, "Connecté", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Combinaison invalide", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onResume() {
        super.onResume()
        val sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)
        if (sharedpreferences.contains(user) && sharedpreferences.contains(passw)){
            if(verifmail(sharedpreferences.getString(user,"")) == true && verifpass(sharedpreferences.getString(passw, "")) == true){
                Toast.makeText(this, "Connecté via la mémoire", Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    private fun verifpass(pass: String): Boolean {
        if(pass.equals("123")){
            return true
        }
        return false
    }

    private fun verifmail(mail: String): Boolean {
        if(mail.equals("admin")){
            return true
        }
        return false
    }


}