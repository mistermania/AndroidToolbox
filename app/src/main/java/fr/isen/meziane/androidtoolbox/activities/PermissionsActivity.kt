package fr.isen.meziane.androidtoolbox.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import fr.isen.meziane.androidtoolbox.R
import kotlinx.android.synthetic.main.activity_permissions.*
import java.io.FileNotFoundException

class PermissionsActivity : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var contactsName = ArrayList<String>()
    val PERMISSIONS_REQUEST_READ_CONTACTS = 100



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(fr.isen.meziane.androidtoolbox.R.layout.activity_permissions)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        contactsName = getContactList()
        if(contactsName != null) {
            Log.i("ContactLinearLayout", "Pass Here")
            viewManager = LinearLayoutManager(this)
            viewAdapter = MyAdapter(contactsName)


            recyclerView = findViewById<RecyclerView>(R.id.recyclerView1).apply {
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)

                // use a linear layout manager
                layoutManager = viewManager

                // specify an viewAdapter (see also next example)
                adapter = viewAdapter

            }
        }


        imageButton.setOnClickListener(){
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            val RESULT_LOAD_IMG = 1
            startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG)
        }

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "First enable LOCATION ACCESS in settings.", Toast.LENGTH_LONG).show();
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSIONS_REQUEST_READ_CONTACTS
            )
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                PERMISSIONS_REQUEST_READ_CONTACTS
            )
        }else {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        textView10.text = "Longitude: " + location.longitude.toString()
                        textView15.text = "Latitue: " + location.latitude.toString()
                    }
                }
        }


    }




    override fun onActivityResult(reqCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(reqCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            try {
                val imageUri = data.data
                val imageStream = contentResolver.openInputStream(imageUri!!)
                val selectedImage = BitmapFactory.decodeStream(imageStream)
                imageButton.setImageBitmap(selectedImage)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show()
        }
    }

    private fun getContactList() : ArrayList<String> {

        var contactListName = ArrayList<String>()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.READ_CONTACTS),
                PERMISSIONS_REQUEST_READ_CONTACTS
            )
        }else {
            val contacts = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
            if (contacts != null && contacts.count > 0) {
                while (contacts.moveToNext()) {
                    val name = contacts.getString(contacts.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                    contactListName.add(name)
                    Log.i("ContactTest", "Nom: " + name)
                }
            }
            contacts.close()
        }
        return contactListName
    }


}
