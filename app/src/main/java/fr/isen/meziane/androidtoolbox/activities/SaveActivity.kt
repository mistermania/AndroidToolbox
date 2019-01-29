package fr.isen.meziane.androidtoolbox.activities

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.gson.GsonBuilder
import fr.isen.meziane.androidtoolbox.R
import fr.isen.meziane.androidtoolbox.model.Informations
import kotlinx.android.synthetic.main.activity_save.*
import java.io.File
import java.io.FileWriter
import java.util.*


class SaveActivity : AppCompatActivity() {

    var an = 0
    var anmonth = 0
    var anday = 0
    var age = 0
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)



        datesave.setOnClickListener(){
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                val realmonth : String
                // Display Selected date in textbox
                if (monthOfYear < 9){
                    realmonth = "0" + (monthOfYear+1).toString()
                }
                else{
                    realmonth = monthOfYear.toString()
                }
                an = year.toInt()
                anmonth = monthOfYear.toInt()
                anday = dayOfMonth.toInt()

                datesave.setText("" + dayOfMonth + " " + realmonth + " " + year)
            }, year, month, day)

            dpd.datePicker.maxDate = Date().time
            dpd.show()
        }

        saveButton.setOnClickListener(){
            val firstn = firstname.text.toString()
            val lastn = lastname.text.toString()
            val dateb = datesave.text.toString()

            if(!firstn.isEmpty() && !lastn.isEmpty() &&!dateb.isEmpty()){
                val gson = GsonBuilder().setPrettyPrinting().create()
                val personne = Informations(firstn, lastn, dateb)
                val json = gson.toJson(personne)

                val filePath = this.getFilesDir().getPath().toString() + "/output.json"

                val file = File(filePath)
                file.writeText(json)

                val bufferead = file.bufferedReader()
                val stringtemp = bufferead.use { it.readText() }

                gson.toJson(personne, FileWriter(filePath))


                println("=== Map from JSON ===")

                val infosPerson : Informations = gson.fromJson(stringtemp, Informations::class.java)

                if(anday >= day && anmonth >= month) {
                    age = year - an
                }
                else{
                    age = year - an - 1
                }
                if(age == -1){
                    age = 0
                }



                val builder = AlertDialog.Builder(this)
                builder.setMessage("Les informations suivantes ont été enregistrées: \n\n Date de naissance: " + infosPerson.birthDate+ " (" + age.toString() + " ans)\n Prénom: " + infosPerson.firstname + "\n Nom: "+ infosPerson.lastname).setNegativeButton("Merci", DialogInterface.OnClickListener { _, _ -> })
                builder.create()
                builder.show()
            }else{
                Toast.makeText(this, "Tous les champs sont requis", Toast.LENGTH_SHORT).show()

            }


        }


    }




}
