package com.example.dialogboxes

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogboxes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Code for button3 for closing the application.
        binding.btnClose.setOnClickListener {

            val builder = AlertDialog.Builder(this)

            builder.setIcon(R.drawable.baseline_exit_to_app_24)
            builder.setTitle("Close app")
            builder.setMessage("Do you really want to exit")

            //For yes button
            builder.setPositiveButton("yes",DialogInterface.OnClickListener { dialogInterface, i ->  
                //What action should performed when user clicked on yes.
                finish()
            })

            //For no button
            builder.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->
                //When user clicked on 'no' no action should performed
            })
            builder.show()
        }


        //Code for button 2 for selecting sweet.
        binding.btnDessert.setOnClickListener {

            val sweets = arrayOf("Rosogolla", "Khir chomchom", "Kalakandh", "Rosh malai")
            val builder2 = AlertDialog.Builder(this)
            builder2.setIcon(R.drawable.baseline_emoji_food_beverage_24)
            builder2.setTitle("Select your favorite sweet")
            builder2.setSingleChoiceItems(sweets,0,DialogInterface.OnClickListener { dialogInterface, i ->
                //When user click on any option what action should be perfomed.
                Toast.makeText(this,"You selected ${sweets[i]}",Toast.LENGTH_SHORT).show()
            })


            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->
                //Do nothing.
            })

            //For no button
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                //Do nothing.
            })
            builder2.show()
        }

        //Code for button3 for selecting food.
        binding.btnMCourse.setOnClickListener {

            val foods = arrayOf("Chicken Biriyani", "Chicken chap", "Raita", "Cold drink")
            val builder3 = AlertDialog.Builder(this,)
            builder3.setIcon(R.drawable.baseline_food_bank_24)
            builder3.setTitle("Select your favorite foods")
            builder3.setMultiChoiceItems(foods, null, DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, isChecked ->
                Toast.makeText(this, "You selected ${foods[i]}", Toast.LENGTH_SHORT ).show()
            })

            builder3.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->
                //Do nothing
            })
            builder3.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
                //Do nothing.
            })
            builder3.show()
        }


    }
}