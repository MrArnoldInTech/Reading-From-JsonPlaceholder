/* 9th May 2023 When this was originally done
 Arnold Fruish Application Response
 This was mini project response I had to do for a job interview.
 */
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;



public class Main {
    private static HttpURLConnection connection;
    private static URL url;
    static String userInput;

    public static void main(String[] args) {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {

            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("----------- Please enter to search for 'posts' or 'users' -----------");
            userInput = myObj.nextLine();
            System.out.println("Answer Given: " + userInput);

            if (userInput.equals("posts")) {
                url = new URL("https://jsonplaceholder.typicode.com/posts"); // loads the website for posts
            }  if (userInput.equals("users")) {
                url = new URL("https://jsonplaceholder.typicode.com/users"); // Otherwise will load the website for users.
            }
            else if (!"posts".equals(userInput)  && (!"users".equals((userInput))) ) {  //If both respsonse dont exist, then the program will simply close with the error code of 64.
                System.out.println("----------- Program has failed, incorrect data -----------");
                System.exit(64); // Can be any number.
            }

            connection = (HttpURLConnection) url.openConnection();
            // Request Setup
            connection.setRequestMethod("GET"); //Used to get the data from the webpage that we are accessing.
            connection.setConnectTimeout(5000); // 5 seconds
            connection.setReadTimeout(5000); // will wait for read timeout of 5 seconds.

            int status = connection.getResponseCode();
            System.out.println(status); // Prints a response code.
            //A good result should be 200 which means that connection to the site was a success.

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }

            parse(responseContent.toString()); // Will call our parse function that is used to break down the JSON values.

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect(); // Best practice is that once we have gotten the information we need from the webiste then we should close the connection.
        }
    }

    public static String parse(String responseBody) {
        if (userInput.equals("posts")) { // If user has entered posts, the the data will be displayed for the posts page.


            JSONArray posts = new JSONArray(responseBody);
            for (int i = 0; i < posts.length(); i++) {
                JSONObject post = posts.getJSONObject(i);
                int id = post.getInt("id");
                int userId = post.getInt("userId");
                String title = post.getString("title");
                String body = post.getString("body");
                System.out.println("ID: " + id + "  " + "Title: " + title + "  " + "userID: " + userId + " " + "Post: " + body + "\n");
            }
            return null;
        } else if (userInput.equals("users")) { //If the user has written users then the data will be displayed that best suits the users page.

            JSONArray users = new JSONArray(responseBody);
            //JSONArray adresses = new JSONArray(responseBody);
            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                //JSONObject address = adresses.getJSONObject(i);
                int id = user.getInt("id");
                String name = user.getString("name");
                String username = user.getString("username");
                String email = user.getString("email");

                //Must call an object within another object to access the string of Address.
                JSONObject address = user.getJSONObject("address");
                String street = address.getString("street");
                String suite = address.getString("suite");
                String city = address.getString("city");
                String zipcode = address.getString("zipcode");

                //Same again we must create a new object here in order to access the Strings.
                JSONObject geo = address.getJSONObject("geo");
                String lat = geo.getString("lat");
                String lng = geo.getString("lng");

                String phone = user.getString("phone");
                String website = user.getString("website");

                JSONObject company = user.getJSONObject("company");
                String namecompany = company.getString("name");
                String catchphrase = company.getString("catchPhrase");
                String bs = company.getString("bs");

                System.out.println("ID: " + id + "  " + "Name: " + name + "  " + "Username: " + username + " " + "Email: " + email + "\n" +
                        "Address: " + "Street: "+  street + " " + "Suite: " + suite + " " + "City: " + city + " " + "Zipcode: " + zipcode +
                        " " + "Geo: " + "Lat: " + lat + " " + "Lng: " + lng + "\n" +
                        "Phone: "  + phone + " " + "Website: " + website + "\n" +
                        "Company: " + "Name: " + namecompany + " " + "CatchPhrase: " + catchphrase + " " + "BS: " + bs + " "  +" \n");
            }
        }
        return null;
    }
}