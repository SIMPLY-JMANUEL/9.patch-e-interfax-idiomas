package com.example.idioma;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textViewBienvenido;
    private String[] idiomas;  // Array para almacenar los textos en diferentes idiomas
    private int currentIndex = 0;  // Índice para controlar el texto actual
    private Handler handler = new Handler();  // Handler para controlar el retardo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Forzar idioma español
        Locale locale = new Locale("es"); // Establecer el idioma a español
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        setContentView(R.layout.activity_main);

        // Obtener la referencia del TextView
        textViewBienvenido = findViewById(R.id.textViewBienvenido);

        // Array de los diferentes textos de "Bienvenido" en distintos idiomas
        idiomas = new String[] {
                getString(R.string.bienvenido),  // Español (default)
                getString(R.string.welcome),     // Inglés
                getString(R.string.accueillir),  // Francés
                getString(R.string.willkommen)   // Alemán
        };

        // Iniciar el cambio de idiomas
        cambiarIdioma();
    }

    // Método para cambiar el texto en el TextView con retardo
    private void cambiarIdioma() {
        // Establecer el texto actual
        textViewBienvenido.setText(idiomas[currentIndex]);

        // Incrementar el índice
        currentIndex++;

        // Reiniciar el índice si se llega al final del array
        if (currentIndex >= idiomas.length) {
            currentIndex = 0;
        }

        // Retraso de 3 segundos (3000 milisegundos) antes de cambiar al siguiente idioma
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cambiarIdioma();  // Llamada recursiva para continuar cambiando idiomas
            }
        }, 3000); // Retraso de 3 segundos
    }
}


