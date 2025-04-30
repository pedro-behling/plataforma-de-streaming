package br.com.alura.pedroflix.main;


import br.com.alura.pedroflix.template.Title;
import br.com.alura.pedroflix.template.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.undo.AbstractUndoableEdit;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        String title;
        Scanner reader = new Scanner(System.in);

        System.out.println("Qual o filme desejado?");
        title = reader.next();

        String search = "http://www.omdbapi.com/?t=" + title + "&apikey=bfb3e823";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(search))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
        System.out.println(myTitleOmdb);

        Title myTitle = new Title(myTitleOmdb);
        System.out.println(myTitle);
    }
}
