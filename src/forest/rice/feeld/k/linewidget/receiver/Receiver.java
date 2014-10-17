
package forest.rice.feeld.k.linewidget.receiver;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import forest.rice.feeld.k.linewidget.db.DBAccess;

public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        Bundle extras = intent.getExtras();
        //
        // for (String key : extras.keySet()) {
        // Object o = extras.get(key);
        //
        // // if (o instanceof String) {
        // // System.out.println((String) o);
        // // } else
        // if (o instanceof CharSequence) {
        // System.out.println(
        // key + " : " + ((CharSequence) o).toString()
        // );
        // }
        //
        // }

        int icon = extras.getInt("EXTRA_ICON");
        String packagename = extras.getString("EXTRA_PACKAGE_NAME");
        long posttime = extras.getLong("EXTRA_POSTTIME");
        String title = extras.getCharSequence(Notification.EXTRA_TEXT) != null ? extras
                .getCharSequence(
                        Notification.EXTRA_TEXT).toString() : "";
        String text = extras.getCharSequence(Notification.EXTRA_TITLE) != null ? extras
                .getCharSequence(
                        Notification.EXTRA_TITLE).toString() : "";

        DBAccess dbAccess = new DBAccess(context);
        dbAccess.insert(packagename, title, text, icon, posttime);

        // try {
        // Bitmap bitmap = BitmapFactory.decodeResource(
        // context.createPackageContext(packagename, 0)
        // .getResources(), icon);
        //
        // FileOutputStream fileOutputStream = new
        // FileOutputStream("/sdcard/output.png");
        // bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
        // fileOutputStream.close();
        // } catch (NameNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

    }
}
