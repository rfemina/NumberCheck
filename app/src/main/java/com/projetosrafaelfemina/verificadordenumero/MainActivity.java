package com.projetosrafaelfemina.verificadordenumero;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.projetosrafaelfemina.verificadordenumero.databinding.ActivityMainBinding;
import com.projetosrafaelfemina.verificadordenumero.utils.NumberUtils;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btCheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkNumber();
            }
        });

    }

    private void checkNumber() {
        String numero = binding.txtNumber.getText().toString();
        if (numero.isEmpty()) {
            binding.txtResult.setText("Digite um número válido!");
        } else {
            int result = Integer.parseInt(binding.txtNumber.getText().toString());
            binding.txtResult.setText("O número " + result + " é " + (NumberUtils.isEven(result) ? "par" : "ímpar") + ".");
        }
    }

}