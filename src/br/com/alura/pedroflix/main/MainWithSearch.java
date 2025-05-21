package br.com.alura.pedroflix.main;

import br.com.alura.pedroflix.exceptions.YearConversionError;
import br.com.alura.pedroflix.template.Title;
import br.com.alura.pedroflix.template.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.undo.AbstractUndoableEdit;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reader = new Scanner(System.in);

        String title = "";
        List<Title> titlesList = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!title.equalsIgnoreCase("sair")) {

            System.out.println("Qual o filme desejado?");
            title = reader.next();

            if (title.equalsIgnoreCase("sair")) {
                break;
            }

            String search = "http://www.omdbapi.com/?t=" + title.replace(" ", "+") + "&apikey=bfb3e823";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(search))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                System.out.println(search);
                TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
                System.out.println(myTitleOmdb);
                Title myTitle = new Title(myTitleOmdb);
                System.out.println(myTitle);

                titlesList.add(myTitle);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (YearConversionError e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println(titlesList);

        FileWriter fileWriter = new FileWriter("filmes.json");
        fileWriter.write(gson.toJson(titlesList));
        fileWriter.close();

        System.out.println("O programa finalizou corretamente!");
    }
}
