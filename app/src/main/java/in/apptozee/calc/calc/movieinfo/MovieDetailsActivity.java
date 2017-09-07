package in.apptozee.calc.calc.movieinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import in.apptozee.calc.calc.R;
import in.apptozee.calc.calc.movieinfo.model.CastModel;
import in.apptozee.calc.calc.movieinfo.model.MovieModel;

/**
 * Created by amareshjana on 28/03/17.
 */

public class MovieDetailsActivity extends AppCompatActivity {
    private TextView movieName;
    private TextView movieDesc;
    private TextView movCat;
    private TextView movAwards;
    private TextView movDir;
    private TextView movProd;
    private TextView movScreenplay;
    private TextView musicDir;
    private TextView hero;
    private TextView heroin;
    private TextView writere;
    private TextView releaseDate;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        findViews();
        asignValues();
    }

    private void asignValues() {
        Bundle mBundle = getIntent().getExtras();
        MovieModel movieModel = (MovieModel) mBundle.getSerializable("MovieModel");
        CastModel mCastModel = (CastModel) mBundle.getSerializable("CastModel");

        movieName.setText(movieModel.getMovieName());
        movieDesc.setText(movieModel.getMovieDesc());
        movCat.setText(movieModel.getMovieCategory());
        movAwards.setText(movieModel.getMovieAwards());
        movDir.setText(mCastModel.getMovDirector());
        movProd.setText(mCastModel.getMobProducer());
        movScreenplay.setText(mCastModel.getMovScreenPlay());
        musicDir.setText(mCastModel.getMovMusic());
        hero.setText(mCastModel.getMovHero());
        heroin.setText(mCastModel.getMovHeroin());
        writere.setText(mCastModel.getMovWrite());
        releaseDate.setText(movieModel.getMovieReleaseDate());
    }

    private void findViews() {
        movieName = (TextView) findViewById(R.id.movie_name);
        movieDesc = (TextView) findViewById(R.id.movie_desc);
        movCat = (TextView) findViewById(R.id.mov_cat);
        movAwards = (TextView) findViewById(R.id.mov_awards);
        movDir = (TextView) findViewById(R.id.mov_dir);
        movProd = (TextView) findViewById(R.id.mov_prod);
        movScreenplay = (TextView) findViewById(R.id.mov_screenplay);
        musicDir = (TextView) findViewById(R.id.music_dir);
        hero = (TextView) findViewById(R.id.hero);
        heroin = (TextView) findViewById(R.id.heroin);
        writere = (TextView) findViewById(R.id.writere);
        releaseDate = (TextView) findViewById(R.id.release_date);
    }

}