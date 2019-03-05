package com.insightfullogic.java8.by.test;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Track;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.insightfullogic.java8.examples.chapter1.SampleData.aLoveSupreme;
import static com.insightfullogic.java8.examples.chapter1.SampleData.manyTrackAlbum;
import static com.insightfullogic.java8.examples.chapter1.SampleData.sampleShortAlbum;

/**
 * @author by5388  on 2019/3/5.
 */

class StreamTest {
    public static void main(String[] args) {
        List<Album> albums = new ArrayList<>();
        albums.add(aLoveSupreme);
        albums.add(sampleShortAlbum);
        albums.add(manyTrackAlbum);
        test1(albums);
        test2(albums);
        test3(albums);
    }

    /**
     * 找出专辑中时间大于1分钟的歌曲:传统的方法
     */
    public static void test1(List<Album> albums) {
        Set<String> names = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                if (track.getLength() > 60) {
                    names.add(track.getName());
                }
            }
        }
        System.out.println("test1 = " + names.size());
    }

    /**
     * 找出专辑中时间大于1分钟的歌曲：重构步骤1
     */
    public static void test2(List<Album> albums) {
        Set<String> names = new HashSet<>();
        albums.forEach(album -> {
            album.getTracks().forEach(track -> {
                if (track.getLength() > 60) {
                    names.add(track.getName());
                }
            });
        });
        System.out.println("test2 = " + names.size());
    }


    /**
     * 找出专辑中时间大于1分钟的歌曲：重构步骤2
     * 操作有点类似RxJava2中的操作符
     */
    public static void test3(List<Album> albums) {
        //获取流
        Stream<Album> stream = albums.stream();
        //转换流
        Stream<Track> trackStream = stream.flatMap(new Function<Album, Stream<Track>>() {
            @Override
            public Stream<Track> apply(Album album) {
                return album.getTracks();
            }
        });
        //对流进行筛选
        trackStream = trackStream.filter(new Predicate<Track>() {
            @Override
            public boolean test(Track track) {
                return track.getLength() > 60;
            }
        });
        //再次转化->所需要的String类型的流
        Stream<String> stringStream = trackStream.map(new Function<Track, String>() {
            @Override
            public String apply(Track track) {
                return track.getName();
            }
        });
        //最终的结果
        Set<String> names2 = new HashSet<>();
        stringStream.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                names2.add(s);
            }
        });

        System.out.println("test3 = " + names2.size());
    }

    /**
     * 找出专辑中时间大于1分钟的歌曲 ：重构步骤3
     */
    public static void test4(List<Album> albums) {
        //获取流
        Stream<Album> stream = albums.stream();
        //转换流
        Stream<Track> trackStream = stream.flatMap(new Function<Album, Stream<Track>>() {
            @Override
            public Stream<Track> apply(Album album) {
                return album.getTracks();
            }
        });
        //对流进行筛选
        trackStream = trackStream.filter(new Predicate<Track>() {
            @Override
            public boolean test(Track track) {
                return track.getLength() > 60;
            }
        });
        //再次转化->所需要的String类型的流
        Stream<String> stringStream = trackStream.map(new Function<Track, String>() {
            @Override
            public String apply(Track track) {
                return track.getName();
            }
        });
        //最终的结果
        Set<String> names2 = new HashSet<>();
        stringStream.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                names2.add(s);
            }
        });

        System.out.println("test3 = " + names2.size());
    }
}
