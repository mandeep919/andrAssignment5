package com.mandeep.andassignment5

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import android.app.DatePickerDialog as DatePickerDialogA

class MainActivity : AppCompatActivity() {

    private lateinit var etDateJoin: Button
    private lateinit var etDOB: Button
    private lateinit var tvJoinDate: TextView
    private lateinit var tvAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etDateJoin = findViewById(R.id.etDateJoin)
        etDOB = findViewById(R.id.etDOB)
        tvJoinDate = findViewById(R.id.tvJoinDate)
        tvAge = findViewById(R.id.tvAge)

        val currentDate= SimpleDateFormat("dd").format(System.currentTimeMillis()).toInt()
        val currentMonth= SimpleDateFormat("MM").format(System.currentTimeMillis()).toInt()
        val currentYear= SimpleDateFormat("yyyy").format(System.currentTimeMillis()).toInt()

        fun YearsWorked(year:Int, month:Int, dayOfMonth:Int):String {
            var Date=currentDate
            var Month=currentMonth
            var Year=currentYear
            val ageDay:Int
            val ageMonth:Int
            val ageYear:Int

            if (dayOfMonth > Date)
            {
                Date +=31
                Month -=1
                ageDay = Date - dayOfMonth
            }
            else
            {
                ageDay = Date - dayOfMonth
            }

            if (month > Month)
            {
                Month +=12
                Year -=1
                ageMonth = Month - month
            }
            else
            {
                ageMonth = Month - month
            }
            ageYear = Year - year

            return "No. of years worked: " + ageYear.toString() + " years " + ageMonth.toString() + " months " + ageDay.toString() + " days"
        }

        val datePicker= DatePickerDialogA(this,
                DatePickerDialogA.OnDateSetListener { view, year, month, dayOfMonth ->
                    etDateJoin.setText("$dayOfMonth-${month + 1}-$year")
                    tvJoinDate.text=YearsWorked(year, month+1, dayOfMonth)
                },
                currentYear,
                currentMonth-1,
                currentDate
        )

        etDateJoin.setOnClickListener {
            datePicker.show()
        }

        //        for age part ---
        fun age(year:Int, month:Int, dayOfMonth:Int):String {
            var Date=currentDate
            var Month=currentMonth
            var Year=currentYear
            val ageDay:Int
            val ageMonth:Int
            val ageYear:Int

            if (dayOfMonth > Date)
            {
                Date +=31
                Month -=1
                ageDay = Date - dayOfMonth
            }
            else
            {
                ageDay = Date - dayOfMonth
            }

            if (month > Month)
            {
                Month +=12
                Year -=1
                ageMonth = Month - month
            }
            else
            {
                ageMonth = Month - month
            }
            ageYear = Year - year

            return "Your Age is: " + ageYear.toString() + " years " + ageMonth.toString() + " months " + ageDay.toString() + " days"
        }

        tvAge=findViewById(R.id.tvAge)
        val datePickerDialogAge= DatePickerDialogA(this,
                DatePickerDialogA.OnDateSetListener { view, year, month, dayOfMonth ->
                    etDOB.setText("$dayOfMonth-${month + 1}-$year")
                    tvAge.text = age(year, month + 1, dayOfMonth)
                },
                currentYear,
                currentMonth - 1,
                currentDate
        )

        etDOB.setOnClickListener {
            datePickerDialogAge.show()
        }
    }
}