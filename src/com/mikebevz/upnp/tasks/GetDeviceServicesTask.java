package com.mikebevz.upnp.tasks;

import android.os.AsyncTask;
import org.cybergarage.upnp.Device;
import org.cybergarage.upnp.ServiceList;

/**
 * @author mikebevz
 */
public class GetDeviceServicesTask extends AsyncTask<Device, Integer, ServiceList> {

private OnDeviceServiceList delegate;

@Override
protected void onPreExecute() {
  super.onPreExecute();
  delegate.OnDeviceServiceListPreExecute();
}


@Override
protected ServiceList doInBackground(Device... devices) {
  publishProgress(100);
  return devices[0].getServiceList();
}


@Override
protected void onPostExecute(ServiceList result) {
  this.delegate.OnDeviceServiceListSuccess(result);
}

public void setOnDeviceServiceListHandler(OnDeviceServiceList delegate) {
  this.delegate = delegate;
}
}
