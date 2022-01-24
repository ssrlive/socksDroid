package com.ssrlive.socksdroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import android.util.Log;

import com.ssrlive.socksdroid.util.Profile;
import com.ssrlive.socksdroid.util.ProfileManager;
import com.ssrlive.socksdroid.util.Utility;
import static com.ssrlive.socksdroid.BuildConfig.DEBUG;

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = BootReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Profile p = new ProfileManager(context).getDefault();

            if (p.autoConnect() && VpnService.prepare(context) == null) {

                if (DEBUG) {
                    Log.d(TAG, "starting VPN service on boot");
                }

                Utility.startVpn(context, p);
            }
        }
    }
}
