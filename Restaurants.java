public class Restaurants{
    //instance variables
    private int rank;
    private String name, cuisine;
    //constructors
    public Restaurants(int rank, String name, String cuisine){
        this.rank = rank;
        this.name = name;
        this.cuisine = cuisine;
    }
    //getters
    public int getRank(){return this.rank;}
    public String getName(){return this.name;}
    public String getCuisine(){return this.cuisine;}
    //question What is the most recurring cusine in the top 100 list both years lets do 2025 first

}
