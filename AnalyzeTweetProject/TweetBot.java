// Kylah Moon
// CSE 122 - Section Ak
// 12/6/2022
// TweetBot Class
// This class reads in a list of tweets and finds the size, adds a tweet, finds the next tweet,
// and removes a tweet, and resets the iteraction of 'next tweet' to start at the beginning
import java.util.*;
import java.io.*;

public class TweetBot {
    
    private List<String> tweetsList;
    private int counts;

    // Constructor: This method creates a list of all the tweets from a file and
    // inititalizes the variables. It also throws an exception if the tweets
    // size is less than 0. 
    // Parameters: List<String> tweets -  a List of tweets from a file.
    public TweetBot(List<String> tweets){
       tweetsList = new LinkedList<String>();
        if(tweets.size() < 1){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < tweets.size(); i++){
          tweetsList.add(tweets.get(i));
        }
        counts = 0;
    }

    // This method returns the number of tweets.
    // Returns: tweetsList.size() - size of TweetList
    public int numTweets(){
       return tweetsList.size();
    }

    
    // This method adds a tweet to the list.
    // Parameters: String tweet = a tweet the user inputs.
    public void addTweet(String tweet){
        tweetsList.add(tweet);
    }


    // This method returns the next tweet in the list using a count variable.
    // Returnes String tweet - the tweet at the index of count.
    public String nextTweet(){        
        if(counts < tweetsList.size()){
            String tweet = tweetsList.get(counts);
            counts++;
            return tweet;
        }else{
            counts = 1;
            return tweetsList.get(0);
        }
    }

    // This method removes a tweet from the list.
    // Parameters: String tweet = a tweet the user inputs.
    public void removeTweet(String tweet){
        if(tweetsList.contains(tweet)){
            if(counts > tweetsList.indexOf(tweet)){
                counts -= 1;
            }
            tweetsList.remove(tweetsList.indexOf(tweet));
        }   
    }

    // This method resets the index of next Tweet by setting count to 0
    public void reset(){
        counts = 0; 
    }
}   