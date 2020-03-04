package com.example.shoab.easylearn;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "registeruser";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";
    private static final String status = "status";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

         sqLiteDatabase.execSQL("CREATE TABLE registeruser(ID INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,password TEXT)");
         sqLiteDatabase.execSQL("CREATE TABLE DRUGLIST (ID INTEGER PRIMARY KEY AUTOINCREMENT,drugname TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DRUGLIST");
        onCreate(sqLiteDatabase);
    }
    public Cursor GetAllData(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        return sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
    }

    public long addUser(String user,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password", password);
        long res =db.insert("registeruser",null,contentValues);
        db.close();
        return res;
    }

    public long draglist(String dragname){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("MedicineName",dragname);
        long status=db.insert("DRUGLIST",null,contentValues);
        db.close();
        return status;
    }
    public Cursor getDragData(){
        SQLiteDatabase database=this.getWritableDatabase();

        return database.rawQuery("SELECT * FROM DRUGLIST",null);

    }

    public boolean checkUser(String username,String password){
        String[]columns = { COL_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count =cursor.getCount();
        cursor.close();
        db.close();
        if(count>0)
            return true;
        else
            return false;
    }

    public void DeleteRegestratopm(String username,String password){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM registeruser WHERE username = '"+username+ "' AND password = '"+password+"'");
        sqLiteDatabase.close();

    }
    public void DeleteSingleDrag(String dragname){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM DRUGLIST WHERE username = '"+dragname);
        sqLiteDatabase.close();
    }
    public long addDrag(String dragname){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("MedicineName",dragname);
        db.execSQL("INSERT INTO  DRUGLIST(MedicineName) VALUES("+dragname+")");
       // long res =db.insert("DRUGLIST",null,contentValues);
        db.close();
        return res;
    }

}
