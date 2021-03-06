package com.morajavier.practicaunoismd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.morajavier.practicaunoismd.calculosoperaciones.CalculoOperaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho, btnNueve, btnCero,
            btnBorrar, btnSumar, btnRestar, btnMultiplicar, btnDividir, btnResultado;
    private EditText resultadoPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultadoPantalla = findViewById(R.id.edtResultadoX);

        btnResultado = findViewById(R.id.buttonIgualX);
        btnBorrar = findViewById(R.id.buttonBorrarX);
        btnSumar = findViewById(R.id.buttonSumarX);
        btnRestar = findViewById(R.id.buttonRestarX);
        btnMultiplicar = findViewById(R.id.buttonMultiplicarX);
        btnDividir = findViewById(R.id.buttonDividirX);


        btnCero = findViewById(R.id.buttonCeroX);
        btnUno = findViewById(R.id.buttonUnoX);
        btnDos = findViewById(R.id.buttonDosX);
        btnTres = findViewById(R.id.buttonTresX);
        btnCuatro = findViewById(R.id.buttonCuatroX);
        btnCinco = findViewById(R.id.buttonCincoX);
        btnSeis = findViewById(R.id.buttonSeisX);
        btnSiete = findViewById(R.id.buttonSieteX);
        btnOcho = findViewById(R.id.buttonOchoX);
        btnNueve = findViewById(R.id.buttonNueveX);
        /*Listeners*/


        btnCero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("0");
            }
        });
        btnUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("1");
            }
        });
        btnDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("2");
            }
        });
        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("3");
            }
        });
        btnCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("4");
            }
        });
        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("5");
            }
        });
        btnSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("6");
            }
        });
        btnSiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("7");
            }
        });
        btnOcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("8");
            }
        });
        btnNueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("9");
            }
        });
        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("+");
            }
        });
        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("-");
            }
        });
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("*");
            }
        });
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moverCursor("/");
            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultadoPantalla.setText("");
            }
        });
        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalculoOperaciones resultadOperandos = new CalculoOperaciones(resultadoPantalla.getText().toString());
                resultadoPantalla.setText("");
                resultadoPantalla.setText(resultadOperandos.infijoAPostfijo()+"");
                Toast.makeText(MainActivity.this,"ads", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("Operaciones chidas");
                alerta.setIcon(R.mipmap.cuete);
                alerta.setMessage("Operaciones");
                alerta.setPositiveButton("Calculando", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alerta.setNegativeButton("Positivo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alerta.show();
            }
        });

    }
    private void moverCursor(String numero){
        this.resultadoPantalla.append(numero);
        this.resultadoPantalla.setSelection(resultadoPantalla.length());
    }
}