package com.example.renewablesources.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.example.renewablesources.R

class RecommendedUsageAmount : AppCompatActivity() {

    var noOfUnits = 0.0

    private lateinit var etUnitsUsed:EditText
    private lateinit var tvBillAmount:TextView

    private lateinit var amount1: EditText
    private lateinit var amount2: EditText
    private lateinit var amount3: EditText

    private lateinit var usage1: TextView
    private lateinit var usage2: TextView
    private lateinit var usage3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommended_usage_amount)

        etUnitsUsed = findViewById(R.id.etUnitsUsed)
        tvBillAmount = findViewById(R.id.tvBillAmount)

        amount1 = findViewById(R.id.amount1)
        amount2 = findViewById(R.id.amount2)
        amount3 = findViewById(R.id.amount3)

        usage1 = findViewById(R.id.usage1)
        usage2 = findViewById(R.id.usage2)
        usage3 = findViewById(R.id.usage3)

        etUnitsUsed.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                computingUsages()
            }
        })

        amount1.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                calculateAmount1()
            }

        })

        amount2.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                calculateAmount2()
            }

        })

        amount3.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                calculateAmount3()
            }

        })
    }

    private fun computingUsages() {

        if (etUnitsUsed.text.isEmpty()) {
            tvBillAmount.text = ""
            return
        }

        //1.Get the value of the used units
        val billAmount = etUnitsUsed.text.toString().toDouble()

//        val amount1 = amount1.text.toString().toDouble()
//        val amount2 = amount2.text.toString().toDouble()
//        val amount3 = amount3.text.toString().toDouble()

        //2.Calculate the bill

        if (billAmount <= 1300) {
            noOfUnits = (billAmount - 400) / 30
        } else if (billAmount <= 2560) {
            noOfUnits = (((billAmount - 550) - 900) / 37) + 30
        } else if (billAmount <= 3820) {
            noOfUnits = (((billAmount - 550) - (900 + 1110) ) / 42) + 60
        } else if (billAmount <= 5180) {
            noOfUnits = (((billAmount - 650) - (900 + 1110 + 1260))/42) + 90
        } else if (billAmount <= 9030) {
            noOfUnits = (((billAmount - 1500) - (900 + 1110 + 1260 + 1260))/50) + 120
        } else {
            noOfUnits = (((billAmount - 2000) - (900 + 1110 + 1260 + 1260 + 3000))/75) + 180
        }

        //3.Update the UI
        tvBillAmount.text = "%.3f".format(noOfUnits)

//        val p1 = totalBill * 0.5
//        val p2 = totalBill * 0.3
//        val p3 = totalBill * 0.2
//
//        val p1EachItem = p1 / amount1
//        val p2EachItem = p2 / amount2
//        val p3EachItem = p3 / amount3
//
//        usage1.text = ".1".format(p1EachItem)
//        usage2.text = ".1".format(p2EachItem)
//        usage3.text = ".1".format(p3EachItem)

    }

    private fun calculateAmount1(){
        if (amount1.text.isEmpty()) {
            usage1.text = ""
            return
        }

        val amount1 = amount1.text.toString().toInt()
        var p1UsableAmount = (noOfUnits * 0.5) / amount1

        usage1.text = "%.1f".format(p1UsableAmount)

    }

    private fun calculateAmount2(){
        if (amount2.text.isEmpty()) {
            usage1.text = ""
            return
        }

        val amount2 = amount2.text.toString().toInt()
        var p1UsableAmount = (noOfUnits * 0.3) / amount2

        usage2.text = "%.1f".format(p1UsableAmount)

    }

    private fun calculateAmount3(){
        if (amount1.text.isEmpty()) {
            usage1.text = ""
            return
        }

        val amount3 = amount3.text.toString().toInt()
        var p1UsableAmount = (noOfUnits * 0.2) / amount3

        usage3.text = "%.1f".format(p1UsableAmount)

    }
}