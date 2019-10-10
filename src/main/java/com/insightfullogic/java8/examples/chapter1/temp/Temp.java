package com.insightfullogic.java8.examples.chapter1.temp;

import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.stream.Stream;

import static com.insightfullogic.java8.examples.chapter1.SampleData.johnColtrane;
import static com.insightfullogic.java8.examples.chapter1.SampleData.johnLennon;
import static com.insightfullogic.java8.examples.chapter1.SampleData.theBeatles;

/**
 * @author by5388  on 2019/5/5.
 */

class Temp {

    private List<Artist> mArtists;

    public Temp() {
        mArtists = new ArrayList<>();
        mArtists.add(johnColtrane);
        mArtists.add(johnLennon);
        mArtists.add(theBeatles);
    }

    public List<Artist> getArtists() {
        return mArtists;
    }


    public Observable get(){
        return  new Observable();
    }
}
