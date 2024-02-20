package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // 0 -> Nada, 1 -> Suma, 2-> Resta, 3-> Multiplicacion y 4-> Division
    var operando: Int = 0
    var contPunto: Int = 0
    lateinit var tv: TextView
    lateinit var tv2: TextView
    var numero1: Double = 0.0
    var numero2: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.result)
        tv2 = findViewById(R.id.stringRes)
        var clear = findViewById<Button>(R.id.btnLimpiar)
        var res = findViewById<Button>(R.id.btnIgual)


        res.setOnClickListener{
            numero2 =tv.text.toString().toDouble()
            var respuesta: Double = 0.0

            when(operando){
                1 -> respuesta = numero1 + numero2
                2 -> respuesta = numero1 - numero2
                3 -> respuesta = numero1 * numero2
                4 -> {
                    if (numero2 != 0.0 ){
                    respuesta = numero1 / numero2
                    }
                    else tv.setText("ERROR")
                }
            }
            val respuestaStr: String = respuesta.toString()
            tv.setText(respuestaStr)
        }

        clear.setOnClickListener{
            operando = 0
            contPunto = 0
            tv.setText("")
            tv2.setText("")
            numero1 = 0.0
            numero2 = 0.0
        }
    }

    fun presionarBoton(view: View){
        val num2: String = tv.text.toString()
        when(view.id){
            R.id.btn0 -> tv.setText(num2 + "0")
            R.id.btn1 -> tv.setText(num2 + "1")
            R.id.btn2 -> tv.setText(num2 + "2")
            R.id.btn3 -> tv.setText(num2 + "3")
            R.id.btn4 -> tv.setText(num2 + "4")
            R.id.btn5 -> tv.setText(num2 + "5")
            R.id.btn6 -> tv.setText(num2 + "6")
            R.id.btn7 -> tv.setText(num2 + "7")
            R.id.btn8 -> tv.setText(num2 + "8")
            R.id.btn9 -> tv.setText(num2 + "9")
            R.id.btnPunto -> {
                if (contPunto == 0 ){
                    tv.setText(num2 + ".")
                    contPunto+=1
                }else{
                    tv.setText(num2)
                }

            }
        }
    }

    fun presionarOperando(view: View){
        numero1 = tv.text.toString().toDouble()
        val numero2Str: String = tv.text.toString()
        when(view.id){
            R.id.btnMas ->{
                tv2.setText(numero2Str + "+")
                tv.setText("")
                operando = 1
            }
            R.id.btnMenos ->{
                tv2.setText(numero2Str + "-")
                tv.setText("")
                operando = 2
            }
            R.id.btnMultiplicacion ->{
                tv2.setText(numero2Str + "x")
                tv.setText("")
                operando = 3
            }
            R.id.btnDivision ->{
                tv2.setText(numero2Str + "/")
                tv.setText("")
                operando = 4
            }
        }
    }
}