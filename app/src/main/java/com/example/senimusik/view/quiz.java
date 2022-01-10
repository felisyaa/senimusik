package com.example.senimusik.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.senimusik.R;
import com.example.senimusik.model.materi1;
import com.example.senimusik.view.viewModel.materi1ViewViewModel;

public class quiz extends AppCompatActivity {

    private TextView quiz_title;
    private String materi1_id = "";
    private materi1ViewViewModel viewModel;
    private ImageView quiz_image;
    private Button pilA,pilB,pilC,pilD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        viewModel = new ViewModelProvider(quiz.this).get(materi1ViewViewModel.class);

        Intent intent = getIntent();
        materi1_id = intent.getStringExtra("materi1_id");

        quiz_title = findViewById(R.id.quiz_title_textView);
        quiz_image = findViewById(R.id.quiz_image);
        pilA =findViewById(R.id.quiz_pilA_button);
        pilB = findViewById(R.id.quiz_pilB_button);
        pilC = findViewById(R.id.quiz_pilC_button);
        pilD = findViewById(R.id.quiz_pilD_button);

        viewModel.getMateri1ById(materi1_id);
        viewModel.getResultgetMateri1ById().observe(quiz.this, showQuiz);
    }

    private Observer<materi1> showQuiz = new Observer<materi1>() {
        @Override
        public void onChanged(materi1 materi1) {
//            final materi1.materi1s materi1s =

//            for (int i=1; i<)
            quiz_title.setText(materi1.getSoal());
        }
    };
}