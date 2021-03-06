package com.mikebevz.upnp.device_browser.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import com.mikebevz.upnp.R;
import com.mikebevz.upnp.device_browser.ServiceDetailsAdapter;
import org.cybergarage.upnp.Service;

import java.util.ArrayList;

/**
 * @author mikebevz
 */
public class ServiceDetailsActivity extends Activity implements OnClickListener {

private Service service;
private ProgressDialog dialog;

@Override
public void onCreate(Bundle icicle) {
  super.onCreate(icicle);

  setContentView(R.layout.service_details);

  Bundle bundle = getIntent().getExtras();
  int position = bundle.getInt("position");

  Button servicesBtn = (Button) findViewById(R.id.services_btn);
  servicesBtn.setOnClickListener(this);

  ServiceDetailsAdapter adapter = new ServiceDetailsAdapter(this, position);

  ArrayList<String> properties = new ArrayList<String>();
  adapter.setData(properties);

  ListView listView = (ListView) findViewById(R.id.list_view);
  listView.setAdapter(adapter);

}

public void onClick(View view) {
  Intent intent = new Intent(this, ActionListActivity.class);
  intent.putExtra("position", getIntent().getExtras().getInt("position"));
  startActivity(intent);
}
}
