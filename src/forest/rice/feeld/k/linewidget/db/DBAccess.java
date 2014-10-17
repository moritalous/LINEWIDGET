
package forest.rice.feeld.k.linewidget.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBAccess {

    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase db;

    private static final String TABLE_HISTORY = "history";

    private static final String COLUMN_PACKAGENEME = "packagename";
    private static final String COLUMN_USER = "user";
    private static final String COLUMN_MESSAGE = "message";
    private static final String COLUMN_ICON = "icon";
    private static final String COLUMN_POSTTIME = "posttime";

    public DBAccess(Context context) {

        sqLiteHelper = new SQLiteHelper(context);
        db = sqLiteHelper.getWritableDatabase();
    }

    public long insert(String packagename, String user, String message, int icon, long posttime) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PACKAGENEME, packagename);
        values.put(COLUMN_USER, user);
        values.put(COLUMN_MESSAGE, message);
        values.put(COLUMN_ICON, icon);
        values.put(COLUMN_POSTTIME, posttime);

        return db.insert(TABLE_HISTORY, null, values);

    }

}
