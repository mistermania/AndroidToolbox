package fr.isen.meziane.androidtoolbox.activities

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import fr.isen.meziane.androidtoolbox.CycleFragment
import fr.isen.meziane.androidtoolbox.R
import kotlinx.android.synthetic.main.activity_life_cycle.*

class LifeCycleActivity : AppCompatActivity(),
    CycleFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val TAG = "stateChange"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        Log.i(TAG,"onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"onStart")
        start.text = "onStart..."
    }

    override fun onResume() {
        super.onResume()
        start.text = start.text.toString() + "onResume..."
        Log.i(TAG,"onResume")
    }

        override fun onPause() {
        super.onPause()
        start.text = start.text.toString() + "onPause..."
        Log.i(TAG,"onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i(TAG,"onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestroy")
        Toast.makeText(this, "onDestroy function executed", Toast.LENGTH_LONG).show()

    }

}
