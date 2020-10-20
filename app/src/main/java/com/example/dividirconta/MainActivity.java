package com.example.dividirconta;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onClickCalcular(View v) {
        //entrada de dados
        TextView valor = (TextView) findViewById(R.id.edtValor);
        TextView pessoas = (TextView) findViewById(R.id.edtPessoas);
        TextView txtResultados = (TextView) findViewById(R.id.txtResultado);


        //regras para verificar se existe algum valor nullo ou vazio

        //valor verifica se tem algum valor
        if  (valor.length() == 0) {
            Toast.makeText(this, "Tem que existir algum valor",
                    Toast.LENGTH_LONG).show();
            return;
        }
        //pessoas verifica se tem algum valor
            if  (pessoas.length() == 0) {
            Toast.makeText(this, "Tem que existir alguma pessoa para multiplicar",
                    Toast.LENGTH_LONG).show();
            return;
        }


        //pega o valor em String e aceita os valors com virgula e ponto
        String stValor = valor.getText().toString().replaceAll(",", ".");
        String stPessoa = pessoas.getText().toString().replaceAll(",", ".");

        //converte para double
        double n1 = Double.parseDouble(stValor);
        double n2 = Double.parseDouble(stPessoa);


            if  (n1 == 0) {
            Toast.makeText(this, "Valor da conta tem que ser maior que 0",
                    Toast.LENGTH_LONG).show();
            return;


            //Regra Nao pode dividir por 0
            }else if (n2 == 0) {
                    Toast.makeText(this, "Não é possível dividir por 0",
                        Toast.LENGTH_LONG).show();
                    return;
            }else{

            //calcula a divisao
            double resultado = n1 / n2;

            //Deixei Duas Opções


            //Com Cifrão R$ ##,##
            //Locale ptBr = new Locale("pt", "BR");
            //txtResultados.setText(NumberFormat.getCurrencyInstance(ptBr).format(resultado));


            //SEM CIFRÃO ##,##
            NumberFormat nf = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
            txtResultados.setText(nf.format(resultado));
        }
    }



}