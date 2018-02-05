package com.syh.deeepoch.deecommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CommunityGhostActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_community_ghost);
    findViewById(R.id.tv_c_g).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(CommunityGhostActivity.this,DeeCommunityActivity.class));
      }
    });
  }
}
