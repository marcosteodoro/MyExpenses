package coms.example.marcosvinicius.myexpenses.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import coms.example.marcosvinicius.myexpenses.model.Categoria;

public class DaoCategoria extends SQLiteOpenHelper {

    private SQLiteDatabase database;

    public DaoCategoria(Context context) {
        super(context, "MyExpenses", null, 1);

        String sql = "CREATE TABLE IF NOT EXISTS Categoria (id INTEGER PRIMARY KEY, descricao TEXT NOT NULL);";

        this.database = getWritableDatabase();

        this.database.execSQL(sql);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Categoria;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Categoria obCategoria) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues obContentValues = new ContentValues();

        obContentValues.put("descricao", obCategoria.getDescricao());

        db.insert("Categoria", null, obContentValues);
    }

    public List<Categoria> select() {
        String sql = "SELECT * FROM Categoria;";

        SQLiteDatabase db = getReadableDatabase();

        Cursor obCursor = db.rawQuery(sql, null);

        List<Categoria> categorias = new ArrayList<Categoria>();

        while (obCursor.moveToNext()) {

            Categoria obCategoria = new Categoria();


            categorias.add(obCategoria);
        }

        obCursor.close();

        return categorias;
    }
}
