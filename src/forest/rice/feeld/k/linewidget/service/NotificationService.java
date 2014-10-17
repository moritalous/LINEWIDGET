
package forest.rice.feeld.k.linewidget.service;

import android.app.Notification;
import android.content.Intent;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

public class NotificationService extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {

        Notification notification = statusBarNotification.getNotification();

        Intent intent = new Intent();
        intent.setAction("forest.rice.feeld.k.receiver1");
        intent.putExtra("EXTRA_ICON", notification.icon);
        intent.putExtra("EXTRA_POSTTIME", statusBarNotification.getPostTime());
        intent.putExtra("EXTRA_PACKAGE_NAME", statusBarNotification.getPackageName());
        // intent.putExtra("EXTRA_TITLE",
        // notification.extras.getCharSequence("EXTRA_TITLE"));
        // intent.putExtra("EXTRA_TEXT",
        // notification.extras.getCharSequence("EXTRA_TEXT"));
        intent.putExtras(notification.extras);
        sendBroadcast(intent);

    }

    @Override
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
    }

}
