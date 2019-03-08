package utilidadopenstreetmap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Grupo 2 (David Da Silva, Sergio Vazquez, Carlos Perez, David Grande)
 */
public class OpenStreetMapUtils {
//    public final static Logger log = Logger.getLogger("OpenStreeMapUtils");

    private static OpenStreetMapUtils instance = null;
    private JSONParser jsonParser;

    public OpenStreetMapUtils() {
        jsonParser = new JSONParser();
    }

    public static OpenStreetMapUtils getInstance() {
        if (instance == null) {
            instance = new OpenStreetMapUtils();
        }
        return instance;
    }

    private String getRequest(String url) throws Exception {

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        //  System.out.println(url);
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        //  System.out.println(con.getResponseCode());
        if (con.getResponseCode() != 200) {
            System.out.println(con.getResponseCode());
            return null;
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public Map<String, Double> getCoordinates(String address) {
        Map<String, Double> res;
        StringBuffer query;
        String[] split = address.split(" ");
        System.out.println(split);
        String queryResult = null;

        query = new StringBuffer();
        res = new HashMap<String, Double>();

        query.append("https://nominatim.openstreetmap.org/search.php?q=");

        if (split.length == 0) {
            return null;
        }

        for (int i = 0; i < split.length; i++) {

            query.append(split[i]);

            if (i < (split.length - 1)) {
                query.append("+");
            }
        }
        System.out.println(query);
        query.append("&format=json&addressdetails=1");

        try {
            queryResult = getRequest(query.toString());

        } catch (Exception e) {
            //           log.error("Error when trying to get data with the following query " + query);
            // System.out.println("error en peticion");
        }

        if (queryResult == null) {
            System.out.println("error en peticion");
            return null;
        }

        Object obj = JSONValue.parse(queryResult);
        //       log.debug("obj=" + obj);

        if (obj instanceof JSONArray) {
            JSONArray array = (JSONArray) obj;
            if (array.size() > 0) {
                JSONObject jsonObject = (JSONObject) array.get(0);

                String lon = (String) jsonObject.get("lon");
                String lat = (String) jsonObject.get("lat");
                //            log.debug("lon=" + lon);
                //            log.debug("lat=" + lat);
                res.put("lon", Double.parseDouble(lon));
                res.put("lat", Double.parseDouble(lat));

            }
        }

        return res;
    }
}
