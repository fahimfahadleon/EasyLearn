package com.example.shoab.easylearn;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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

         sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,password TEXT,status TEXT)");
         sqLiteDatabase.execSQL("CREATE TABLE DRUGLIST (ID INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,type TEXT,description TEXT,solution TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DRUGLIST");
        onCreate(sqLiteDatabase);
    }
    public Cursor GetAllData(String tablename){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        return sqLiteDatabase.rawQuery("SELECT * FROM "+tablename,null);
    }

    public long addUser(String user,String password,String status){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("username",user);
        contentValues.put("password", password);
        contentValues.put("status",status);
        long res =db.insert("registeruser",null,contentValues);
        db.close();
        return res;
    }

    public long addDrag(String dragname,String dragtype,String dragdescription,String dragsolution){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",dragname);
        contentValues.put("type",dragtype);
        contentValues.put("description",dragdescription);
        contentValues.put("solution",dragsolution);
        long status=db.insert("DRUGLIST",null,contentValues);
        db.close();
        return status;
    }
    public Cursor getDragData(){
        SQLiteDatabase database=this.getWritableDatabase();

        return database.rawQuery("SELECT * FROM DRUGLIST",null);

    }

    public boolean checkUser(String username,String password,String statu){
        String[]columns = {COL_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=? and " + status + "=?";
        String[] selectionArgs = { username, password, statu};
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count =cursor.getCount();
        cursor.close();
        db.close();
        if(count>0)
            return true;
        else
            return false;
    }

    public void DeleteRegestration(String username,String password){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM registeruser WHERE username = '"+username+ "' AND password = '"+password+"'");
        sqLiteDatabase.close();

    }
    public void DeleteSingleDrag(String dragname){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM DRUGLIST WHERE username = '"+dragname);
        sqLiteDatabase.close();
    }
//    public long addDrag(String dragname){
//        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//        contentValues.put("MedicineName",dragname);
//        db.execSQL("INSERT INTO  DRUGLIST(MedicineName) VALUES("+dragname+")");
//        long res =db.insert("DRUGLIST",null,contentValues);
//        db.close();
//        return res;
//    }

    public ArrayList<String> getWords() {
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT en_word FROM words", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(cursor.getColumnIndex("en_word")));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public ArrayList<Model> fetchdatabyfilter(String inputText) throws SQLException {
        ArrayList<Model> data= new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();

        if (inputText != null  ||  inputText.length () < 0)  {
            //query = "SELECT * FROM "+dbTable+" WHERE "+filtercolumn+" like '%"+inputText+"%'";
            String query = "SELECT * FROM DRUGLIST WHERE name LIKE '"+inputText+"%'"+"LIMIT 10";

            Cursor row = database.rawQuery(query, null);
            if (row != null) {
                row.moveToFirst();
                while(!row.isAfterLast()){

                    int id=row.getInt(row.getColumnIndex("ID"));
                    String name=row.getString(row.getColumnIndex("name"));
                    String type = row.getString(row.getColumnIndex("type"));
                    String description = row.getString(row.getColumnIndex("description"));
                    String solution = row.getString(row.getColumnIndex("solution"));

                    data.add(new Model(id,name,type,description,solution));
                    // do what ever you want here
                    row.moveToNext();
                }

                row.close();
            }
        }
        else{
            data=null;
        }


        return data;
    }

}
