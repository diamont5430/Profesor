package client;

import commons.Translation;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PutIntoDB {

    public static void main(String[] args) throws FileNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        Scanner sc = new Scanner(new File("client/src/main/resources/tlumaczenia1"));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" - ");
            Translation translation = new Translation(tokens[0], tokens[1]);
            //restTemplate.postForObject("http://localhost:8080/api/translation", translation, Translation.class);
        }
    }
}
