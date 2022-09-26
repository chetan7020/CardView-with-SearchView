package com.example.cardviewwithsearchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llData;
    private SearchView svSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llData = findViewById(R.id.llData);
        svSearch = findViewById(R.id.svSearch);

        for (int i = 1; i <101; i++) {
            View view = getLayoutInflater().inflate(R.layout.card_layout , null , false);

            TextView textView= view.findViewById(R.id.tvNumber);

            textView.setText(String.valueOf(i));

            llData.addView(view);
        }

        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                for (int i = 0; i < llData.getChildCount(); i++) {
                    TextView textView = llData.getChildAt(i).findViewById(R.id.tvNumber);
                    CardView cardView = llData.getChildAt(i).findViewById(R.id.cvCard);

                    if (! textView.getText().toString().contains(s.trim())){
                        cardView.setVisibility(View.GONE);
                    }else{

                        cardView.setVisibility(View.VISIBLE);
                    }
                }

                return false;
            }
        });

    }
}