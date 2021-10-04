package com.example.practic7_multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.practic7_multiplication.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Random random = new Random();
    private int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        refreshQuiz();
        binding.buttonAnswer.setOnClickListener(view -> checkAnswer());

    }

    private void refreshQuiz() {
        int left = random.nextInt(10) + 1;
        int right = random.nextInt(10) + 1;

        binding.number1.setText(Integer.toString(left));
        binding.number2.setText(Integer.toString(right));
        binding.editAnswer.setText("");
        answer = left * right;
    }

    private void checkAnswer() {
        String string = binding.editAnswer.getText().toString();

        if(string.isEmpty()) {
            Toast.makeText(this, "정답을입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        int value = Integer.parseInt(string);
        if (value == answer) {
            Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "오답입니다. 다시 한번 생각해보세요요", Toast.LENGTH_SHORT).show();
        }
    }

}