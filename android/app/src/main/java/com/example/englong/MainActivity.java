package com.example.englong;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnPing = findViewById(R.id.btnPing);
        TextView tvResult = findViewById(R.id.tvResult);

        btnPing.setOnClickListener(v -> {
            tvResult.setText("通信中...");

            Request request = new Request.Builder()
                    .url("http://10.0.2.2:8080/health")
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(() ->
                            tvResult.setText("NG: " + e.getClass().getSimpleName())
                    );
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String body = response.body() != null ? response.body().string() : "(no body)";
                    runOnUiThread(() ->
                            tvResult.setText("OK: " + body)
                    );
                }
            });
        });
    }
}
