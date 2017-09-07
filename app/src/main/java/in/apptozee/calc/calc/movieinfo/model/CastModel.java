package in.apptozee.calc.calc.movieinfo.model;

import java.io.Serializable;

/**
 * Created by amareshjana on 27/03/17.
 */

public class CastModel implements Serializable{

    private String movDirector;
    private String mobProducer;
    private String movScreenPlay;
    private String movMusic;
    private String movHero;
    private String movHeroin;
    private String movWrite;

    public CastModel() {
    }

    public CastModel(String movDirector, String mobProducer, String movScreenPlay,
                     String movMusic, String movHero, String movHeroin, String movWrite) {
        this.movDirector = movDirector;
        this.mobProducer = mobProducer;
        this.movScreenPlay = movScreenPlay;
        this.movMusic = movMusic;
        this.movHero = movHero;
        this.movHeroin = movHeroin;
        this.movWrite = movWrite;
    }

    public String getMovDirector() {
        return movDirector;
    }

    public String getMobProducer() {
        return mobProducer;
    }

    public String getMovScreenPlay() {
        return movScreenPlay;
    }

    public String getMovMusic() {
        return movMusic;
    }

    public String getMovHero() {
        return movHero;
    }

    public String getMovHeroin() {
        return movHeroin;
    }

    public String getMovWrite() {
        return movWrite;
    }

    public void setMovDirector(String movDirector) {
        this.movDirector = movDirector;
    }

    public void setMobProducer(String mobProducer) {
        this.mobProducer = mobProducer;
    }

    public void setMovScreenPlay(String movScreenPlay) {
        this.movScreenPlay = movScreenPlay;
    }

    public void setMovMusic(String movMusic) {
        this.movMusic = movMusic;
    }

    public void setMovHero(String movHero) {
        this.movHero = movHero;
    }

    public void setMovHeroin(String movHeroin) {
        this.movHeroin = movHeroin;
    }

    public void setMovWrite(String movWrite) {
        this.movWrite = movWrite;
    }
}
