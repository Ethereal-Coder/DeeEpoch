package com.syh.deeepoch.deeec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EcGhostActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ec_ghost);
    findViewById(R.id.tv_c_g).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(EcGhostActivity.this,DeeEcActivity.class));
      }
    });
  }
}
