/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikebevz.upnp.activities;

import android.content.Context;
import android.widget.ListView;
import com.mikebevz.upnp.ActivityState;
import com.mikebevz.upnp.DeviceListAdapter;
import com.mikebevz.upnp.R;
import com.mikebevz.upnp.WifiDisabledException;
import com.mikebevz.upnp.WifiNotConnectedException;

/**
 *
 * @author mikebevz
 */
class StateAppStarted implements ActivityState {
    private final Context context;
    private final MainActivity mainActivity;

    public StateAppStarted(Context context) {
        this.context = context;
        this.mainActivity = (MainActivity)context;
    }

    public void setSettings() {
        
        mainActivity.setContentView(R.layout.main);
        
        mainActivity.devicesList = (ListView) mainActivity.findViewById(R.id.devices_list);
        mainActivity.devListAdapter = new DeviceListAdapter(mainActivity);
        
        
        try {
            mainActivity.setContentView(R.layout.main);
            mainActivity.devListAdapter.startControlPoint();
            mainActivity.devicesList.setAdapter(mainActivity.devListAdapter);
            mainActivity.devicesList.setOnItemClickListener(mainActivity);
            //Toast toast = Toast.makeText(context, R.string.restarting_scanning, Toast.LENGTH_SHORT);
            //toast.show();
            
        } catch (WifiNotConnectedException e) {
            mainActivity.setState(mainActivity.STATE_WIFI_NOTCONNECTED);
        } catch (WifiDisabledException e) {
            mainActivity.setState(mainActivity.STATE_WIFI_DISABLED);
        }
    }
    
    
    
}
