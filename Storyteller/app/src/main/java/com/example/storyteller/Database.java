package com.example.storyteller;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Database {
    public static final String TABLE_NAME = "bookcard";

    // column names
    public static final String BOOK_ID_COLUMN = "book_id";
    public static final String QUESTION_COLUMN = "question";
    public static final String ANSWER_COLUMN = "answer";
    public static final String CATEGORY_COLUMN = "category";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    BOOK_ID_COLUMN + " TEXT NOT NULL, " +
                    QUESTION_COLUMN + " TEXT, " +
                    ANSWER_COLUMN + " TEXT, " +
                    CATEGORY_COLUMN + " TEXT)";

    // db instance
    private SQLiteDatabase db;

    public Database(Context context) {
        db = MyDBHelper.getDatabase(context);
    }

    public void close() {
        db.close();
    }

    public BookCard insert(BookCard item) {

        ContentValues cv = new ContentValues();

        cv.put(BOOK_ID_COLUMN, item.getBookIdentifier());
        cv.put(QUESTION_COLUMN, item.getQuestion());
        cv.put(ANSWER_COLUMN, item.getAnswer());
        cv.put(CATEGORY_COLUMN, item.getCategory());

        db.insertOrThrow(TABLE_NAME, null, cv);

        return item;
    }

    public ArrayList<BookCard> getAll(String bookIdentifier) {
        ArrayList<BookCard> result = new ArrayList<>();
        String where = BOOK_ID_COLUMN + "=?";
        Cursor cursor = db.query(
                TABLE_NAME, null, where, new String[] {bookIdentifier}, null, null, null, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }

        cursor.close();
        return result;
    }

//    // 取得指定編號的資料物件
//    public BookCard get(long id) {
//        // 準備回傳結果用的物件
//        Item item = null;
//        // 使用編號為查詢條件
//        String where = KEY_ID + "=" + id;
//        // 執行查詢
//        Cursor result = db.query(
//                TABLE_NAME, null, where, null, null, null, null, null);
//
//        // 如果有查詢結果
//        if (result.moveToFirst()) {
//            // 讀取包裝一筆資料的物件
//            item = getRecord(result);
//        }
//
//        // 關閉Cursor物件
//        result.close();
//        // 回傳結果
//        return item;
//    }

    public int getCount(String bookIdentifier) {
        int result = 0;
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM bookcard WHERE " +  BOOK_ID_COLUMN + "=?", new String[] {bookIdentifier});

        if (cursor.moveToNext()) {
            result = cursor.getInt(0);
        }

        return result;
    }

    public BookCard getRecord(Cursor cursor) {

        BookCard result = new BookCard(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return result;
    }

    public void clearDatabase() {
        String clearDBQuery = "DELETE FROM "+TABLE_NAME;
        db.execSQL(clearDBQuery);
    }

}