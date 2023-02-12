// Kylah Moon
// CSE 122 - Section Ak
// 12/6/2022
// This is a porgram that analyzes a list of tweets and returns what the most
// frequent word is. 
import java.util.*;
import java.io.*;

public class TwitterMain {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("tweets.rxt")); // Make Scanner over tweet file
        List<String> tweets = new ArrayList<>();
        while (input.hasNextLine()) { // Add each tweet in file to List
           tweets.add(input.nextLine());
        }

        TweetBot bot = new TweetBot(tweets); // Create TweetBot object with list of tweets

        TwitterTrends trends = new TwitterTrends(bot); // Create TwitterTrends object

        System.out.println("The most frequent word is: " + trends.getMostFrequentWord());
        
        trends.covid();
    }
}