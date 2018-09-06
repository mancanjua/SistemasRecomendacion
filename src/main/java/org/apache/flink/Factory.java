package org.apache.flink;

import pojos.*;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Factory {

    public static Movie createMovie(String s) {
        Movie res = new Movie();

        String[] trozos = s.split(",");
        if(trozos.length < 3) {
            throw new IllegalArgumentException();
        }

        Integer id = new Integer(trozos[0].trim());
        String titulo = trozos.length == 4 ? (trozos[1]+ trozos[2]).trim() : trozos[1].trim();
        String generos = trozos.length == 4 ? trozos[3].trim() : trozos[2].trim();

        res.setMovieId(id);
        res.setTitle(titulo.replaceAll("\"", ""));
        res.setGenres(organizaGeneros(generos));

        return res;
    }

    private static List<Genre> organizaGeneros(String s) {
        return Arrays.asList(s.split("\\|")).stream().map(g -> Genre.getValue(g)).collect(Collectors.toList());
    }

    public static Link createLink(String s) {
        Link res = new Link();

        String[] trozos = s.split(",");
        if(trozos.length < 2) {
            throw new IllegalArgumentException();
        }

        Integer movieId = new Integer(trozos[0].trim());
        Integer imdbId = new Integer(trozos[1].trim());
        Integer tmdbId = trozos.length == 3 ? new Integer(trozos[2].trim()) : null;

        res.setMovieId(movieId);
        res.setImdbId(imdbId);
        res.setTmdbId(tmdbId);

        return res;
    }

    public static Rating createRating(String s) {
        Rating res = new Rating();

        String[] trozos = s.split(",");
        if(trozos.length < 3) {
            throw new IllegalArgumentException();
        }

        Integer userId = new Integer(trozos[0].trim());
        Integer movieId = new Integer(trozos[1].trim());
        Double rating = new Double(trozos[2].trim());
        Long timestamp = new Long(trozos[3].trim());

        res.setUserId(userId);
        res.setMovieId(movieId);
        res.setRating(rating);
        res.setTimestamp(timestamp);

        return res;
    }

    public static Tag createTag(String s) {
        Tag res = new Tag();

        String[] trozos = s.split(",");
        if(trozos.length < 4) {
            throw new IllegalArgumentException();
        }

        Integer userId = new Integer(trozos[0].trim());
        Integer movieId = new Integer(trozos[1].trim());
        String tag = "";
        for(int i = 2; i < trozos.length - 1; i++) {
            tag += trozos[i];
        }
        Long timestamp = new Long(trozos[trozos.length - 1].trim());

        res.setUserId(userId);
        res.setMovieId(movieId);
        res.setTag(tag);
        res.setTimestamp(timestamp);

        return res;
    }

}
