import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ApiMovies {

    public static void main(String[] args) {
        // Reemplaza "TU_CLAVE_DE_API" con tu propia clave de API de TMDb
        String apiKey = "df103bad3b668d9b3f6e0defe8de0240";
        String apiUrl = "https://api.themoviedb.org/3/discover/movie?api_key=" + apiKey + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate";


        try {
            // Realizar la solicitud HTTP
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Obtener la respuesta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                // Imprimir la respuesta (puedes procesarla según tus necesidades)
                System.out.println(response.toString());
            } else {
                System.out.println("Error en la solicitud. Código de respuesta: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}