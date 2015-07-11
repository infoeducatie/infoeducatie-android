package com.infoeducatie.app.client.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelper {
    /* the gson library will convert the json to objects */
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

    /* converts a json text to a object */
    public static <T> T stringToObject(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }

    /* reads the text from a httpurlconnection response */
    public static String readHttpUrlConnectionResponse(
            HttpURLConnection urlConnection) {
        int code = 0;
        String responseText = null;
        try {
            code = urlConnection.getResponseCode();
            InputStream inputStream = (InputStream) urlConnection.getContent();
            responseText = fromStream(inputStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /* returning the httphelperresponse entity */
        return responseText;
    }

	/*
	 * creates a httpurlconnection for our requests. here we are setting the
	 * headers
	 */;

    public static HttpURLConnection createHttpUrlConnection(String path,
                                                            String method, Object body) throws IOException {
		/* create a simple http url connection */
        URL url = new URL(path);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        boolean methodIsGet = method.toLowerCase().equals("get");
		/* if we do a get request we must set this to false */
        ;
        httpCon.setDoOutput(!methodIsGet);
        httpCon.setRequestMethod(method);
        httpCon.setRequestProperty("Accept", "application/json");
        httpCon.setRequestProperty("Content-Type", "application/json");
        if (body != null) {
            // if we have a body add it
            OutputStreamWriter out = new OutputStreamWriter(
                    httpCon.getOutputStream());

            out.write(gson.toJson(body));
            out.close();
        }
        return httpCon;
    }

    /* converts inputstream to string */
    public static String fromStream(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }
}
