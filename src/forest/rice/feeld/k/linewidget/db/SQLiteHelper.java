
package forest.rice.feeld.k.linewidget.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE = "linewidget.db";
    public static final int DB_VERSION = 1;

    public SQLiteHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE history (" +
                "_id integer primary key autoincrement, " +
                "packagename text, " +
                "user text, " +
                "message text, " +
                "icon integer , " +
                "posttime integer )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
