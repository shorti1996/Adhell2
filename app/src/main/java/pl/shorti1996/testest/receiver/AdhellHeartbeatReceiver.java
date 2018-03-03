package pl.shorti1996.testest.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import pl.shorti1996.testest.service.HeartbeatIntentService;


public class AdhellHeartbeatReceiver extends BroadcastReceiver {
    private static final String TAG = AdhellHeartbeatReceiver.class.getCanonicalName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Starting service");
        Intent i = new Intent(context, HeartbeatIntentService.class);
        i.putExtra("launchedFrom", "alarm-receiver");
        context.startService(i);
    }
}
