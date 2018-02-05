package com.syh.deeepoch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DeeEpochActivity extends AppCompatActivity implements View.OnClickListener {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dee_epoch);
    findViewById(R.id.tv_community).setOnClickListener(this);
    findViewById(R.id.tv_ec).setOnClickListener(this);
  }

  @Override public void onClick(View view) {
    switch (view.getId()){
      case R.id.tv_community:
        //Toast.makeText(DeeEpochActivity.this,"community",Toast.LENGTH_SHORT).show();
        //startActivity(new Intent(DeeEpochActivity.this, DeeCommunityActivity.class));
        break;
      case R.id.tv_ec:
        //Toast.makeText(DeeEpochActivity.this,"ec",Toast.LENGTH_SHORT).show();
        //startActivity(new Intent(DeeEpochActivity.this, DeeEcActivity.class));
        break;
    }
  }
}
