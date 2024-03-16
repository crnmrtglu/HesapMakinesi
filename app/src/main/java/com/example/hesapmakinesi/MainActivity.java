package com.example.hesapmakinesi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText sayiEditText;

    Double ilkSayi;

    Boolean virgulDurum;
    String islemDurum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sayiEditText = findViewById(R.id.sayi);


        Button btnC = findViewById(R.id.btnc);
        Button btnPar = findViewById(R.id.btnpar);
        Button btnYuz = findViewById(R.id.btnyuz);
        Button btnBol = findViewById(R.id.btnbol);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.bnt9);
        Button btnCarp = findViewById(R.id.btncarp);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btnAzt = findViewById(R.id.btnazt);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btnArt = findViewById(R.id.btnart);
        Button btnArtEks = findViewById(R.id.btnarteks);
        Button btn0 = findViewById(R.id.btn0);
        Button btnVirgul = findViewById(R.id.btnvirgul);
        Button btnEsit = findViewById(R.id.btnesit);
        ilkSayi = 0.0;
        islemDurum = "0";

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayiEditText.setText("0");
            }
        });

        btnPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oncekiMetin = sayiEditText.getText().toString();
                if (oncekiMetin.equals("0")) {
                    sayiEditText.setText("(");
                } else {
                    sayiEditText.append("( )");
                }
            }
        });

        btnYuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oncekiMetin = sayiEditText.getText().toString();
                double sayi = Double.parseDouble(oncekiMetin);
                double yuzde = sayi / 100.0;
                sayiEditText.setText(String.valueOf(yuzde));

            }
        });

        btnBol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_symbol("/");
            }
        });
        btnCarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_symbol("*");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_number(8);

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_number(9);

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_number(7);

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_number(6);

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_number(5);

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_number(4);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_number(3);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_number(2);

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_number(1);

            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_number(0);

            }
        });
        btnAzt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_symbol("-");
            }
        });
        btnArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_symbol("+");
            }
        });

        btnEsit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_symbol("=");
            }
        });
    }
    private void  action_number(int sayi)
    {
        if(sayiEditText.getText().toString() == "0"){
            sayiEditText.setText("");
        }
        else if(
                sayiEditText.getText().toString() == "+" ||
                        sayiEditText.getText().toString() == "*" ||
                        sayiEditText.getText().toString() == "/"||
                        sayiEditText.getText().toString() == "%"||
                        sayiEditText.getText().toString() == "-"        )
        {
            sayiEditText.setText("");
        }
        sayiEditText.setText(sayiEditText.getText() + String.valueOf(sayi));
    }
    private void action_symbol(String sembol) {
        switch (sembol) {
            case "=":
                hesapla();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (!islemDurum.equals("")) {
                    hesapla();
                }
                ilkSayi = Double.parseDouble(sayiEditText.getText().toString());
                islemDurum = sembol;
                sayiEditText.setText(sembol);
                break;
        }
    }

    private void hesapla() {
        String oncekiMetin = sayiEditText.getText().toString();
        if (!oncekiMetin.equals("") && !islemDurum.equals("")) {
            double ikinciSayi;
            int sembolIndex = oncekiMetin.indexOf(islemDurum);
            if (sembolIndex != -1) {
                ikinciSayi = Double.parseDouble(oncekiMetin.substring(sembolIndex + 1));
            } else {
                Toast.makeText(MainActivity.this, "İkinci sayıyı girin", Toast.LENGTH_SHORT).show();
                return;
            }

            double sonuc = 0;
            switch (islemDurum) {
                case "+":
                    sonuc = ilkSayi + ikinciSayi;
                    break;
                case "-":
                    sonuc = ilkSayi - ikinciSayi;
                    break;
                case "*":
                    sonuc = ilkSayi * ikinciSayi;
                    break;
                case "/":
                    if (ikinciSayi != 0) {
                        sonuc = ilkSayi / ikinciSayi;
                    } else {
                        Toast.makeText(MainActivity.this, "Sıfıra bölme hatası", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }
            sayiEditText.setText(String.valueOf(sonuc));
            islemDurum = "";
        }
    }

}