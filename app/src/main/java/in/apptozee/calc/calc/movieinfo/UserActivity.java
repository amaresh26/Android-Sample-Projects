package in.apptozee.calc.calc.movieinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import in.apptozee.calc.calc.R;
import in.apptozee.calc.calc.movieinfo.database.DbHelper;
import in.apptozee.calc.calc.movieinfo.model.CastModel;
import in.apptozee.calc.calc.movieinfo.model.MovieModel;

/**
 * Created by amareshjana on 24/03/17.
 */

public class UserActivity extends AppCompatActivity {

    ListView mListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info_user);
        mListView = (ListView) findViewById(R.id.movie_list);

        final DbHelper mDbHelper = new DbHelper(UserActivity.this);
        ArrayList<String> mMovieList = mDbHelper.getMovieList();
        //adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(UserActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, mMovieList);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String movieName = mListView.getItemAtPosition(position).toString();
                MovieModel movieModel = mDbHelper.getMovieDetails(movieName);
                CastModel mCastModel = mDbHelper.getCastDetails(movieModel.getCastId());
                Intent mIntent = new Intent(UserActivity.this, MovieDetailsActivity.class);
                mIntent.putExtra("MovieModel", movieModel);
                mIntent.putExtra("CastModel", mCastModel);
                startActivity(mIntent);
            }
        });
    }
}
