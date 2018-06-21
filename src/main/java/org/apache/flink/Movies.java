package org.apache.flink;

import org.apache.flink.api.common.functions.FilterFunction;
import pojos.Genre;
import pojos.Movie;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Movies {

    public static Movie create(String s) {
        Movie res = new Movie();

        String[] trozos = s.split(",");
        if(trozos.length < 3) {
            throw new IllegalArgumentException();
        }

        Integer id = new Integer(trozos[0].trim());
        String titulo = trozos.length == 4 ? (trozos[1]+ trozos[2]).trim() : trozos[1].trim();
        String generos = trozos.length == 4 ? trozos[3].trim() : trozos[2].trim();

        res.setMovieId(id);
        res.setTitle(trozos[1].trim());
        res.setGenres(organizaGeneros(generos));

        return res;
    }

    private static List<Genre> organizaGeneros(String s) {
        return Arrays.asList(s.split("|")).stream().map(g -> Genre.getValue(g)).collect(Collectors.toList());
    }

}
