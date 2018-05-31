package coms.example.marcosvinicius.myexpenses.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DaoReceitaDespesa extends SQLiteOpenHelper {

    public DaoReceitaDespesa(Context context) {
        super(context, "MyExpenses", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE DespesaReceita (" +
                                        "id INTEGER PRIMARY KEY" +
                                        "idCategoria INTEGER NOT NULL" +
                                        "valor REAL NOT NULL" +
                                        "tipo TEXT NOT NULL" +
                                        "observacao TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
