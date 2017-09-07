package in.apptozee.calc.calc.movieinfo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import in.apptozee.calc.calc.movieinfo.model.CastModel;
import in.apptozee.calc.calc.movieinfo.model.MovieModel;
import in.apptozee.calc.calc.movieinfo.model.UserModel;

/**
 * Created by amareshjana on 24/03/17.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "movie_info.db";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase db;

    //user table fields
    private static final String USER_TABLE = "user_table";
    private static final String USER_ID = "user_id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String MOBILE_NO = "mobile_no";
    private static final String EMAIL = "email";
    private static final String FULL_NAME = "full_name";

    //movie info table
    private static final String MOVIE_INFO_TABLE = "movie_info_table";
    private static final String MOVIE_ID = "movie_id";
    private static final String MOVIE_NAME = "movie_name";
    private static final String MOVIE_DESC = "movie_desc";
    private static final String MOVIE_CATEGORY = "movie_category";
    private static final String MOVIE_RELEASED_DATE = "movie_released_date";
    private static final String MOVIE_AWARDS_WON = "movie_awards_won";
    private static final String MOVIE_RATING = "movie_rating";
    private static final String MOVIE_IMG = "movie_img";

    //CAST_CREW_INFO TABLE
    private static final String CAST_TABLE = "cast_table";
    private static final String CAST_ID = "cast_id";
    private static final String DIRECTOR = "director";
    private static final String PRODUCER = "producer";
    private static final String SCREEN_PLAY = "screen_play";
    private static final String MUSIC = "music";
    private static final String HERO = "hero";
    private static final String HEROIN = "heroin";
    private static final String WRITER = "writer";

    //queries for creatingn tables
    private static final String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + "("
            + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + USERNAME + " VARCHAR NOT NULL, "
            + PASSWORD + " VARCHAR NOT NULL, "
            + MOBILE_NO + " TEXT NOT NULL, "
            + EMAIL + " TEXT NOT NULL, "
            + FULL_NAME + " TEXT NOT NULL);";

    private static final String CREATE_MOVIE_TABLE = "CREATE TABLE " + MOVIE_INFO_TABLE + "("
            + MOVIE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + MOVIE_NAME + " VARCHAR NOT NULL, "
            + MOVIE_DESC + " VARCHAR NOT NULL, "
            + MOVIE_CATEGORY + " VARCHAR NOT NULL, "
            + CAST_ID + " INT NOT NULL, "
            + MOVIE_RELEASED_DATE + " VARCHAR NOT NULL, "
            + MOVIE_AWARDS_WON + " VARCHAR NOT NULL, "
            + MOVIE_RATING + " INT NOT NULL, "
            + MOVIE_IMG + " BLOB);";

    private static final String CREATE_CAST_TABLE = "CREATE TABLE " + CAST_TABLE + "("
            + CAST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + DIRECTOR + " VARCHAR NOT NULL, "
            + PRODUCER + " VARCHAR NOT NULL, "
            + SCREEN_PLAY + " VARCHAR NOT NULL, "
            + MUSIC + " VARCHAR NOT NULL, "
            + HERO + " TEXT, "
            + HEROIN + " TEXT, "
            + WRITER + " TEXT);";

    public DbHelper(Context mContext) {
        super(mContext, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_MOVIE_TABLE);
        db.execSQL(CREATE_CAST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //insertion of data into database will be done here
    public long insertUser(UserModel mUserModel) {
        long id = 0;
        db = getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(USERNAME, mUserModel.getUsername());
            cv.put(PASSWORD, mUserModel.getPassword());
            cv.put(MOBILE_NO, mUserModel.getMobileNo());
            cv.put(EMAIL, mUserModel.getEmail());
            cv.put(FULL_NAME, mUserModel.getFullName());

            id = db.insert(USER_TABLE, null, cv);
        } catch (Exception e) {
            e.printStackTrace();
            return id;
        } finally {
            if (db != null)
                db.close();
        }
        return id;
    }

    public long insertMovie(MovieModel movieModel) {
        long id = 0;
        db = getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(MOVIE_NAME, movieModel.getMovieName());
            cv.put(MOVIE_DESC, movieModel.getMovieDesc());
            cv.put(MOVIE_CATEGORY, movieModel.getMovieCategory());
            cv.put(CAST_ID, movieModel.getCastId());
            cv.put(MOVIE_AWARDS_WON, movieModel.getMovieAwards());
            cv.put(MOVIE_RELEASED_DATE, movieModel.getMovieReleaseDate());
            cv.put(MOVIE_RATING, movieModel.getMovieRating());
            cv.put(MOVIE_IMG, movieModel.getMovieImage());

            id = db.insert(MOVIE_INFO_TABLE, null, cv);
        } catch (Exception e) {
            e.printStackTrace();
            return id;
        } finally {
            if (db != null)
                db.close();
        }
        return id;
    }

    public long insertCast(CastModel castModel) {
        long id = 0;
        db = getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(DIRECTOR, castModel.getMovDirector());
            cv.put(PRODUCER, castModel.getMobProducer());
            cv.put(SCREEN_PLAY, castModel.getMovScreenPlay());
            cv.put(MUSIC, castModel.getMovMusic());
            cv.put(HERO, castModel.getMovHero());
            cv.put(HEROIN, castModel.getMovHeroin());
            cv.put(WRITER, castModel.getMovWrite());

            id = db.insert(CAST_TABLE, null, cv);
        } catch (Exception e) {
            e.printStackTrace();
            return id;
        } finally {
            if (db != null)
                db.close();
        }
        return id;
    }

    //used to check the user is present or not in the db
    public boolean getUserDetails(String username_str, String password_str) {
        db = getWritableDatabase();
        Cursor cursor;
        try {
            String Query = "Select * from " + USER_TABLE + " where " + USERNAME + " = ? and " + PASSWORD + " = ?";
            cursor = db.rawQuery(Query, new String[]{username_str, password_str});
            if (cursor.getCount() <= 0) {
                cursor.close();
                return false;
            }
            cursor.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<String> getMovieList() {
        ArrayList<String> mArray = new ArrayList<>();
        db = getWritableDatabase();
        String query = "Select " + MOVIE_NAME + " from " + MOVIE_INFO_TABLE;
        Cursor mCursor = db.rawQuery(query, null);
        try {
            if (mCursor.moveToFirst()) {
                do {
                    mArray.add(mCursor.getString(mCursor.getColumnIndex(MOVIE_NAME)));
                } while (mCursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null)
                db.close();
            if (mCursor != null)
                mCursor.close();
        }
        return mArray;
    }

    public MovieModel getMovieDetails(String movieName) {
        MovieModel movieModel = new MovieModel();
        db = getWritableDatabase();
        Cursor cursor = null;
        try {
            String Query = "Select * from " + MOVIE_INFO_TABLE + " where " + MOVIE_NAME + " = ?";
            cursor = db.rawQuery(Query, new String[]{movieName});
            if (cursor.moveToFirst()) {
                movieModel.setMovieName(cursor.getString(cursor.getColumnIndex(MOVIE_NAME)));
                movieModel.setMovieDesc(cursor.getString(cursor.getColumnIndex(MOVIE_DESC)));
                movieModel.setMovieCategory(cursor.getString(cursor.getColumnIndex(MOVIE_CATEGORY)));
                movieModel.setMovieAwards(cursor.getString(cursor.getColumnIndex(MOVIE_AWARDS_WON)));
                movieModel.setMovieReleaseDate(cursor.getString(cursor.getColumnIndex(MOVIE_RELEASED_DATE)));
                movieModel.setMovieRating(cursor.getString(cursor.getColumnIndex(MOVIE_RATING)));
                movieModel.setCastId(cursor.getString(cursor.getColumnIndex(CAST_ID)));
            }
            cursor.close();
        } catch (Exception e) {
            if (db != null)
                db.close();
            if (cursor != null)
                cursor.close();
        } finally {
            if (db != null)
                db.close();
            if (cursor != null)
                cursor.close();
        }
        return movieModel;
    }

    public CastModel getCastDetails(String castId) {
        CastModel mCastModel = new CastModel();
        db = getWritableDatabase();
        Cursor mCursor = null;
        try {
            String Query = "Select * from " + CAST_TABLE + " where " + CAST_ID + " = ?";
            mCursor = db.rawQuery(Query, new String[]{castId});
            if (mCursor.moveToFirst()) {
                mCastModel.setMovDirector(mCursor.getString(mCursor.getColumnIndex(DIRECTOR)));
                mCastModel.setMobProducer(mCursor.getString(mCursor.getColumnIndex(PRODUCER)));
                mCastModel.setMovHero(mCursor.getString(mCursor.getColumnIndex(HERO)));
                mCastModel.setMovHeroin(mCursor.getString(mCursor.getColumnIndex(HEROIN)));
                mCastModel.setMovMusic(mCursor.getString(mCursor.getColumnIndex(MUSIC)));
                mCastModel.setMovScreenPlay(mCursor.getString(mCursor.getColumnIndex(SCREEN_PLAY)));
                mCastModel.setMovWrite(mCursor.getString(mCursor.getColumnIndex(WRITER)));
            }
        } catch (Exception e) {
            if (db != null)
                db.close();
            if (mCursor != null)
                mCursor.close();
        } finally {
            if (db != null)
                db.close();
            if (mCursor != null)
                mCursor.close();
        }
        return mCastModel;
    }
}