package com.example.alcoolougasolina

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.70

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            percentual = savedInstanceState.getDouble("percentual")
        }

        var campoGasolina: EditText = findViewById(R.id.edGasolina)
        var campoAlcool: EditText = findViewById(R.id.edAlcool)
        var switch1: Switch = findViewById(R.id.swPercentual)
        var campoResultado: TextView = findViewById(R.id.textView)

        Log.d("PDM23","No onCreate, $percentual")

        switch1.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked) {
                percentual = 0.75
            } else {
                percentual = 0.70
            }
        }

        val btCalc: Button = findViewById(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            var gasolina:Double = campoGasolina.text.toString().toDouble()
            var alcool:Double = campoAlcool.text.toString().toDouble()

            Log.d("PDM23","No btCalcular, gasolina $gasolina")
            Log.d("PDM23","No btCalcular, alcool $alcool")

            var resultado:Double = alcool / gasolina

            if (resultado <= percentual) {
                campoResultado.text = "Álcool"
            } else {
                campoResultado.text = "Gasolina"
            }

            Log.d("PDM23","No btCalcular, $resultado")
        })
    }
    override fun onResume(){
        super.onResume()
        Log.d("PDM23","No onResume, $percentual")
    }
    override fun onStart(){
        super.onStart()
        Log.d("PDM23","No onResume")
    }
    override fun onPause(){
        super.onPause()
        Log.d("PDM23","No onResume")
    }
    override fun onStop(){
        super.onStop()
        Log.d("PDM23","No onResume")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d("PDM23","No onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("percentual", percentual)
        super.onSaveInstanceState(outState)
    }
}