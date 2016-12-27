package io.github.dmi3coder.moviemo.data;


import android.support.test.filters.MediumTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@MediumTest
public class MovieTest {
    Gson gson;

    @Before
    public void setUp() throws Exception {
        gson = new GsonBuilder().create();
    }


    @Test
    public void connectivityTest() throws Exception {
        Movie movie = gson.fromJson(RETURN_DATA, Movie.class);
        assertFalse(movie.getAdult());
        assertEquals(movie.getBudget().intValue(), 40000000);
        System.out.println(movie);
    }

    @After
    public void tearDown() throws Exception {

    }

    public static final String RETURN_DATA = "{\n" +
            "    \"adult\": false,\n" +
            "    \"backdrop_path\": \"/cc3wFUe6GnEEBRzbLBpfjUsmTVh.jpg\",\n" +
            "    \"belongs_to_collection\": null,\n" +
            "    \"budget\": 40000000,\n" +
            "    \"genres\": [\n" +
            "        {\n" +
            "            \"id\": 53,\n" +
            "            \"name\": \"Thriller\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 18,\n" +
            "            \"name\": \"Drama\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 10749,\n" +
            "            \"name\": \"Romance\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 9648,\n" +
            "            \"name\": \"Mystery\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"homepage\": \"\",\n" +
            "    \"id\": 2124,\n" +
            "    \"imdb_id\": \"tt0109456\",\n" +
            "    \"original_language\": \"en\",\n" +
            "    \"original_title\": \"Color of Night\",\n" +
            "    \"overview\": \"When New York psychiatrist Bill Capa visits Los Angeles to take over his murdered colleague's therapy group, he finds himself embroiled in the thick of a mystery when he bumps into Rose and begins a torrid affair.\",\n" +
            "    \"popularity\": 0.575988,\n" +
            "    \"poster_path\": \"/qvNWTJ8m65DDGr8olt1o39OQVkH.jpg\",\n" +
            "    \"production_companies\": [\n" +
            "        {\n" +
            "            \"name\": \"Hollywood Pictures\",\n" +
            "            \"id\": 915\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"Cinergi Pictures Entertainment\",\n" +
            "            \"id\": 1504\n" +
            "        }\n" +
            "    ],\n" +
            "    \"production_countries\": [\n" +
            "        {\n" +
            "            \"iso_3166_1\": \"US\",\n" +
            "            \"name\": \"United States of America\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"release_date\": \"1994-08-19\",\n" +
            "    \"revenue\": 19726050,\n" +
            "    \"runtime\": 121,\n" +
            "    \"spoken_languages\": [\n" +
            "        {\n" +
            "            \"iso_639_1\": \"cs\",\n" +
            "            \"name\": \"Český\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"iso_639_1\": \"en\",\n" +
            "            \"name\": \"English\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"status\": \"Released\",\n" +
            "    \"tagline\": \"In the heat of desire, love can turn to deception. Nothing is what it seems when day turns into night.\",\n" +
            "    \"title\": \"Color of Night\",\n" +
            "    \"video\": false,\n" +
            "    \"vote_average\": 5.6,\n" +
            "    \"vote_count\": 63\n" +
            "}";

}