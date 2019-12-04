package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onSubmit(view:View){

        var checkedId:Int=radioGroup1.checkedRadioButtonId
        var point=0

        if(prob2_a.isChecked && prob2_b.isChecked)
            point+=50
        else if((prob2_a.isChecked==false && prob2_b.isChecked) || (prob2_a.isChecked && prob2_b.isChecked==false ))
            point+=25
        if(checkedId!=-1){
            var checked=radioGroup1.findViewById(checkedId) as RadioButton
            if(checked.text=="Activity")
                point+=50
        }
        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat.getDateTimeInstance() //or use getDateInstance()
        val formatedDate = formatter.format(date)
        var alert=AlertDialog.Builder(this)
        alert.setMessage("Congratulations! You submitted on $formatedDate, Your score is $point %")
        alert.show()
        onReset(view)
    }

    fun onReset(view:View){
        radioGroup1.clearCheck()
        prob2_a.setChecked(false)
        prob2_b.setChecked(false)
    }
}
