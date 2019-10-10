package com.insightfullogic.java8.examples.chapter1.temp;

import com.insightfullogic.java8.examples.chapter1.Artist;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author by5388  on 2019/5/5.
 */
public class TempTest {

    private Temp mSubject;

    @BeforeMethod
    public void setUp() {
        mSubject = new Temp();
    }

    /**
     * 函数式
     */
    @Test
    public void testGetArtists() {
        List<Artist> artists = mSubject.getArtists();
        Stream<Artist> stream = artists.stream();
        stream.forEach(new Consumer<Artist>() {
            @Override
            public void accept(Artist artist) {
                System.out.println(artist.toString());
            }
        });
        // TODO: 2019/5/5 一个 Stream 只可以使用一次
        stream = artists.stream();
        Stream<String> stringStream = stream.map(new Function<Artist, String>() {
            @Override
            public String apply(Artist artist) {
                return artist.getName();
            }
        });
        IntStream intStream = stringStream.mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return value.length();
            }
        });
        int sum = intStream.sum();
        System.out.println(String.format("sum = %d", sum));
        // TODO: 2019/5/5 一个 Stream 只可以使用一次
        stream = artists.stream();
        long count = stream.count();
        System.out.println(String.format("stream.count() = %d", count));

        stream = artists.stream();
        // TODO: 2019/5/5 Java8 Stream 相关的写法、函数都很接近RxJava2中的命名，
        Stream<Artist> soloArtistStream = stream.filter(new Predicate<Artist>() {
            @Override
            public boolean test(Artist artist) {
                //solo 就一个 没有其他的成员，队友
//                return artist.isSolo();
                return true;
            }
        });
        Stream<Artist> sortedArtistStream = soloArtistStream.sorted(new Comparator<Artist>() {
            @Override
            public int compare(Artist o1, Artist o2) {
                int i = o1.getName().compareTo(o2.getName());
                System.out.println(i);
                return i;
            }
        });

        //peek 操作符有点类似于Rxjava的doNext(),可以对数据进行操作
        Stream<Artist> peekArtistStream = sortedArtistStream.peek(new Consumer<Artist>() {
            @Override
            public void accept(Artist artist) {
                System.out.println(artist.getName());
            }
        });
        peekArtistStream.forEach(new Consumer<Artist>() {
            @Override
            public void accept(Artist artist) {
                System.out.println(artist.getName());
            }
        });


    }

}