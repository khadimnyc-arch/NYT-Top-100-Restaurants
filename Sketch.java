import processing.core.PApplet;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Sketch extends PApplet {
    ArrayList<Restaurants> r2024 = new ArrayList <Restaurants>();
    ArrayList<Restaurants> r2025 = new ArrayList <Restaurants>();
    int countIndian24 = 0;
    int countIndian25 = 0;

  public void settings() {
    size(500, 500);
  }

  public void setup() {
    try {
Scanner sc = new Scanner(new File("restaurants2024.txt"));      Scanner sec_sc = new Scanner(new File("restaurants2025.txt"));
      // loop through each line of a file
        //question What is the most recurring cusine in the top 100 list both years lets do 2025 first

      while (sc.hasNextLine()) {
        String r = sc.nextLine();
        String[] arr = r.split(",");

        int rank = Integer.parseInt(arr[0]);
        String name = arr[1];
        String cuisine = arr[2];

        Restaurants res = new Restaurants(rank,name,cuisine);
        r2024.add(res);
        //System.out.println(rank + " " + name);

        
        
      }

        while(sec_sc.hasNextLine()){
            String r = sec_sc.nextLine();
            String[] arr = r.split(",");

            int rank = Integer.parseInt(arr[0]);
            String name = arr[1];
            String cuisine = arr[2];

            Restaurants res = new Restaurants(rank,name,cuisine);
            r2025.add(res);
        //System.out.println(rank + " " + name);
        }
    sec_sc.close();

    sc.close();
    

    // for(Restaurants i : r2024){
    //     if(i.getCuisine().contains("Indian"))
    //         countIndian24++;
    // }

    // for(Restaurants i : r2025){
    //     if(i.getCuisine().contains("Indian"))
    //         countIndian25++;
    // }
    // System.out.println(countIndian24);
    // System.out.println(countIndian25);

    String[] type = {"Indian", "Korean", "French", "Caribbean", "French-Vietnamese", "Mediterranean", "Japanese", "Chinese", "American-Caribbean", "Puerto Rican-Dominican", "Trinidadian", "Egyptian", "Scandinavian", "Italian-American", "Jewish Deli", "Mexican", "Italian", "French-American", "European-American", "Spanish", "Portuguese-Spanish", "American", "American-European", "Albanian", "Pakistani-Indian", "Nigerian", "Iranian", "Asian-American", "Malaysian", "Taiwanese", "French-Viennese", "Uyghur", "Sri Lankan", "Middle Eastern", "Burmese", "Asian-Southern American", "Vietnamese", "French-Italian", "American-Mediterranean", "Thai", "Azerbaijani"};
    //made ai make it into a string for me bc thats a lot of work no lie
    String bestCuisine ="";
    int best = -9999;

    for(String cus : type){
        int count24 = 0;
        int count25 = 0;
        for(Restaurants r : r2024){
            if(r.getCuisine().contains(cus))
                count24++;
        }

        for(Restaurants r : r2025){
            if(r.getCuisine().contains(cus))
                count25++;
        }

        int total = count24+count25;
        if(total>best){
            best=total;
            bestCuisine=cus;
        }
    }
    System.out.println("Most recurring cusine is "+ bestCuisine+ " and it occured "+ best+" times.");



    } catch (Exception e) {
        e.printStackTrace();
    }
  }

  public void draw() {
    
  }

}
