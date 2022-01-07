/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Gopal
 */
public class HangmanGame {
 String word;
    /**
     * @param args the command line arguments
     */
   public String getWord(){
       return word;
   }
    public HangmanGame(){
        
        try {         

            URL url = new URL("https://random-word-api.herokuapp.com/word?number=1");
            //setting url connction
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                informationString.append(scanner.nextLine());
               //storing word into word variable
                scanner.close();
                word=informationString.toString().split("\"")[1].toString();
                System.out.println(word);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    
}
}