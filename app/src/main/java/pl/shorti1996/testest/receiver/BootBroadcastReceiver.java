package pl.shorti1996.testest.receiver;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import pl.shorti1996.testest.blocker.ContentBlocker;
import pl.shorti1996.testest.blocker.ContentBlocker56;
import pl.shorti1996.testest.blocker.ContentBlocker57;
import pl.shorti1996.testest.utils.BlockedDomainAlarmHelper;
import pl.shorti1996.testest.utils.DeviceAdminInteractor;

public class BootBroadcastReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ContentBlocker contentBlocker = DeviceAdminInteractor.getInstance().getContentBlocker();
        if (contentBlocker != null && contentBlocker.isEnabled() && (contentBlocker instanceof ContentBlocker56
                || contentBlocker instanceof ContentBlocker57)) {
            BlockedDomainAlarmHelper.scheduleAlarm();
        }
//        HeartbeatAlarmHelper.scheduleAlarm();
    }
}
