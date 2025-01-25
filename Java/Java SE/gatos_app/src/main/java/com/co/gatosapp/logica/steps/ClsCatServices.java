package com.co.gatosapp.logica.steps;

import com.co.gatosapp.logica.models.ClsCat;
import com.co.gatosapp.logica.models.ClsCatFav;
import com.google.gson.Gson;
import okhttp3.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ClsCatServices {
    public static void seeCat() throws IOException {
        //vamos a traer los datos de la API
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .get()
                .build();
        Response response = client.newCall(request).execute();
        String jsonCat = response.body().string();

        //retirar los corchetes
        jsonCat = jsonCat.substring(1, jsonCat.length());
        jsonCat = jsonCat.substring(0, jsonCat.length()-1);

        //crear un objeto de la clase GSON
        Gson gson = new Gson();
        ClsCat gatos = gson.fromJson(jsonCat, ClsCat.class);

        //remidencionar la imagen en caso de necesitar
        Image image = null;
        try{
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);
            ImageIcon fondoGato = new ImageIcon(image);
            if(fondoGato.getIconWidth()>800){
                //redimencionamos
                Image fondo = fondoGato.getImage();
                Image modificada = fondo.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);

            }
            String menu = "Opciones: \n"
                    + "1. Ver otra imagen \n"
                    + "2. Favorito \n"
                    + "3. Volver \n";
            String [] botones = {"Ver otra imagen", "Favorito", "Volver"};
            String id_gato = String.valueOf(gatos.getId());
            String op = (String) JOptionPane.showInputDialog(null, menu, id_gato, JOptionPane.INFORMATION_MESSAGE,
                    fondoGato,botones,botones[0]);
            int select = -1;
            //Validamos que opcion selecciona el usuario
            for(int i =0; i< botones.length; i ++){
                if(op.equals(botones[i])){
                    select = i;
                }
            }
            switch (select){
                case 0:
                    seeCat();
                    break;
                case 1:
                    favoritoGato(gatos);
                    break;
                default:
                    break;

            }

        }catch (IOException e){
            System.out.println(e);

        }

    }
    public static void favoritoGato(ClsCat gato){
        try{
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n\t\"image_id\": \""+gato.getId()+"\"\r\n\t\r\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", gato.getApiKey())
                    .build();
            Response response = client.newCall(request).execute();
        }catch (IOException e){
            System.out.println(e);

        }

    }

    public static void seeFavority (String apiKey) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/favourites")
                .method("GET", body)
                .addHeader("x-api-key", apiKey)
                .build();
        Response response = client.newCall(request).execute();
        //Guardamos el string con la respuesta
        String jsonCat = response.body().string();
        //Creamos el objeto gson
        Gson gson = new Gson();

        ClsCatFav[] gatosArray = gson.fromJson(jsonCat,ClsCatFav[].class);
        if (gatosArray.length>0){
            int min = 1;
            int max = gatosArray.length;
            int aleatorio = (int) (Math.random()*((max-min)+1))+min;
            int indice = aleatorio-1;

            ClsCatFav gatoFav = gatosArray[indice];
            //remidencionar la imagen en caso de necesitar
            Image image = null;
            try{
                URL url = new URL(gatoFav.getImagex().getUrl());
                image = ImageIO.read(url);
                ImageIcon fondoGato = new ImageIcon(image);
                if(fondoGato.getIconWidth()>800){
                    //redimencionamos
                    Image fondo = fondoGato.getImage();
                    Image modificada = fondo.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                    fondoGato = new ImageIcon(modificada);

                }
                String menu = "Opciones: \n"
                        + "1. Ver otra imagen \n"
                        + "2. Eliminar Favorito \n"
                        + "3. Volver \n";
                String [] botones = {"Ver otra imagen", "Eliminar Favorito", "Volver"};
                String id_gato = String.valueOf(gatoFav.getId());
                String op = (String) JOptionPane.showInputDialog(null, menu, id_gato, JOptionPane.INFORMATION_MESSAGE,
                        fondoGato,botones,botones[0]);
                int select = -1;
                //Validamos que opcion selecciona el usuario
                for(int i =0; i< botones.length; i ++){
                    if(op.equals(botones[i])){
                        select = i;
                    }
                }
                switch (select){
                    case 0:
                        seeFavority(apiKey);
                        break;
                    case 1:
                        deleteFavority(gatoFav);
                        break;
                    default:
                        break;

                }

            }catch (IOException e){
                System.out.println(e);

            }


        }

    }
    public static void deleteFavority(ClsCatFav gatoFav){
        try{
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites/"+gatoFav.getId()+"")
                    .method("DELETE", body)
                    .addHeader("x-api-key", gatoFav.getApiKey())
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();

        }catch (IOException e){
            System.out.println(e);
        }

    }

}
