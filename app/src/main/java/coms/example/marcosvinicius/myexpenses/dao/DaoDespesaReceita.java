package coms.example.marcosvinicius.myexpenses.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.ObjectStreamConstants;
import java.util.ArrayList;
import java.util.List;

import coms.example.marcosvinicius.myexpenses.model.DespesaReceita;

public class DaoDespesaReceita extends SQLiteOpenHelper {

    public DaoDespesaReceita(Context context) {
        super(context, "MyExpenses", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE DespesaReceita (" +
                                        "id INTEGER PRIMARY KEY," +
                                        "idCategoria INTEGER," +
                                        "valor REAL NOT NULL," +
                                        "tipo TEXT NOT NULL," +
                                        "observacao TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS DespesaReceita;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(DespesaReceita obDespesaReceita) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues obContentValues = new ContentValues();

        obContentValues.put("idCategoria", obDespesaReceita.getIdCategoria());
        obContentValues.put("valor", obDespesaReceita.getValor());
        obContentValues.put("tipo", obDespesaReceita.getTipo());
        obContentValues.put("observacao", obDespesaReceita.getObservacao());

        db.insert("DespesaReceita", null, obContentValues);
    }

    public List<DespesaReceita> select() {
        String sql = "SELECT * FROM DespesaReceita;";

        SQLiteDatabase db = getReadableDatabase();

        Cursor obCursor = db.rawQuery(sql, null);

        List<DespesaReceita> despesaReceitas = new ArrayList<DespesaReceita>();

        while (obCursor.moveToNext()) {

            DespesaReceita obDespesaReceita = new DespesaReceita();

            obDespesaReceita.setId(obCursor.getLong(obCursor.getColumnIndex("id")));
            obDespesaReceita.setObservacao(obCursor.getString(obCursor.getColumnIndex("observacao")));
            obDespesaReceita.setIdCategoria(obCursor.getLong(obCursor.getColumnIndex("idCategoria")));
            obDespesaReceita.setValor(obCursor.getDouble(obCursor.getColumnIndex("valor")));
            obDespesaReceita.setTipo(obCursor.getString(obCursor.getColumnIndex("tipo")));

            despesaReceitas.add(obDespesaReceita);
        }

        obCursor.close();

        return despesaReceitas;
    }
}
