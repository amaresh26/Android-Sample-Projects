package in.apptozee.calc.calc.movieinfo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import in.apptozee.calc.calc.R;
import in.apptozee.calc.calc.movieinfo.database.DbHelper;
import in.apptozee.calc.calc.movieinfo.model.CastModel;
import in.apptozee.calc.calc.movieinfo.model.MovieModel;

/**
 * Created by amareshjana on 24/03/17.
 */

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText movieName;
    private EditText movieDesc;
    private EditText movieCat;
    private EditText movieAward;
    private EditText movieDirector;
    private EditText movieProducer;
    private EditText movieScreenPlay;
    private EditText movieMusic;
    private EditText movieHero;
    private EditText movieHeroin;
    private EditText movieWriter;
    private RatingBar ratingBar;
    private Button movieRelease;
    private Button save;
    private int year;
    private int month;
    private int day;

    static final int DATE_PICKER_ID = 1111;

    private void findViews() {
        movieName = (EditText) findViewById(R.id.movie_name);
        movieDesc = (EditText) findViewById(R.id.movie_desc);
        movieCat = (EditText) findViewById(R.id.movie_cat);
        movieAward = (EditText) findViewById(R.id.movie_award);
        movieDirector = (EditText) findViewById(R.id.movie_director);
        movieProducer = (EditText) findViewById(R.id.movie_producer);
        movieScreenPlay = (EditText) findViewById(R.id.movie_screen_play);
        movieMusic = (EditText) findViewById(R.id.movie_music);
        movieHero = (EditText) findViewById(R.id.movie_hero);
        movieHeroin = (EditText) findViewById(R.id.movie_heroin);
        movieWriter = (EditText) findViewById(R.id.movie_writer);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        movieRelease = (Button) findViewById(R.id.movie_release);
        save = (Button) findViewById(R.id.save);

        movieRelease.setOnClickListener(this);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == movieRelease) {
            showDialog(DATE_PICKER_ID);
        } else if (v == save) {
            CastModel mCastModel = new CastModel(movieDirector.getText().toString(), movieProducer.getText().toString(), movieScreenPlay.getText().toString(),
                    movieMusic.getText().toString(), movieHero.getText().toString(), movieHeroin.getText().toString(), movieWriter.getText().toString());
            DbHelper mDbHelper = new DbHelper(AdminActivity.this);
            long id = mDbHelper.insertCast(mCastModel);

            MovieModel movieModel = new MovieModel(movieName.getText().toString(), movieDesc.getText().toString(), movieCat.getText().toString(),
                    movieRelease.getText().toString(), movieAward.getText().toString(), ratingBar.getRating() + "", "", id + "");
            if (mDbHelper.insertMovie(movieModel) > 0) {
                Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_LONG).show();
                clearAllDataAfterInsertion();
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info_admin);
        findViews();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_PICKER_ID:

                // open datepicker dialog.
                // set date picker for current date
                // add pickerListener listner to date picker
                return new DatePickerDialog(this, pickerListener, year, month, day);
        }
        return null;
    }

    //used for date picker
    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // Show selected date
            movieRelease.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));
        }
    };

    //this is to make clear all the feilds after inserting the data into the db
    private void clearAllDataAfterInsertion() {
        movieName.setText("");
        movieDesc.setText("");
        movieCat.setText("");
        movieAward.setText("");
        movieDirector.setText("");
        movieProducer.setText("");
        movieScreenPlay.setText("");
        movieMusic.setText("");
        movieHero.setText("");
        movieHeroin.setText("");
        movieWriter.setText("");
        ratingBar.setRating(0);
        movieRelease.setText("");
    }
}