package com.test.attempt;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.*;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.albums.GetAlbumRequest;
import com.wrapper.spotify.requests.data.artists.GetArtistRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchAlbumsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchArtistsRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class SpotifyRun {
    private static String clientId = "117ce1a5253c4a408c69ef77dc00a007";
    private static String clientSecret = "ae03e37a0cab43e6973ce985e0c87ce5";
    private static final String id = "5zT1JLIj9E57p3e1rFm9Uq";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .build();

    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();

    private static GetAlbumRequest getAlbumRequest;
    private static GetArtistRequest getArtistRequest;

//    final GetSomethingRequest getSomethingRequest = spotifyApi.getSomething("qKRpDADUKrFeKhFHDMdfcu")
//            .market(CountryCode.SE)
//            .build();

    public static void clientCredentials_Sync() {
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            // Set access token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            System.out.println("Expires in: " + clientCredentials.getExpiresIn());
//            System.out.println(spotifyApi.getAccessToken());
//            System.out.println(spotifyApi.getRefreshToken());
        } catch (SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void getAlbum_Sync() {
        getAlbumRequest = spotifyApi.getAlbum(id)
                .market(CountryCode.SE)
                .build();

        String artistID;

        try {
            final Album album = getAlbumRequest.execute();

            System.out.println("Name: " + album.getName());
            System.out.println(album.getAlbumType());

            Map<String, String> externalUrls = album.getExternalUrls().getExternalUrls();

            for (Map.Entry<String, String> entry : externalUrls.entrySet()) {
                System.out.println(entry.getKey() + "  " + entry.getValue());
            }

            ArtistSimplified[] artists = album.getArtists();

            artistID = artists[0].getId();

            getArtistRequest = spotifyApi.getArtist(artistID)
                    .build();

            Artist artist = getArtistRequest.execute();





        } catch (SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void searchArtist(){
        String artist = "Arctic Monkeys";

        SearchArtistsRequest searchArtistsRequest = spotifyApi.searchArtists(artist)
                .market(CountryCode.SE)
                .limit(10)
                .offset(0)
                .build();

        try {
            final Paging<Artist> artistPaging = searchArtistsRequest.execute();

            for (Artist artist1 : artistPaging.getItems()) {

            }

            System.out.println("Total: " + artistPaging.getTotal());
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void searchAlbums(){
        String artist = "Arctic Monkeys";

        SearchAlbumsRequest searchAlbumsRequest = spotifyApi.searchAlbums(artist)
                .market(CountryCode.SE)
                .limit(10)
                .offset(0)
                .build();

        try {
            final Paging<AlbumSimplified> albumSimplifiedPaging = searchAlbumsRequest.execute();

            System.out.println("Total: " + albumSimplifiedPaging.getTotal());

            for (AlbumSimplified albumSimplified : albumSimplifiedPaging.getItems()) {
                System.out.println(albumSimplified.getName());
            }
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        clientCredentials_Sync();
       // getAlbum_Sync();
        searchArtist();
        searchAlbums();

    }

}
