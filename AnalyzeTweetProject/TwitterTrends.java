// Kylah Moon
// CSE 122 - Section Ak
// 12/6/2022
// TwitterTrends Class
// This is a porgram that analyzes a list of tweets and returns what the most frequent word is.
// It also finds if the program contians 'covid' or 'pandemic' and links to the cdc if it does.
import java.util.*;
import java.io.*;

public class TwitterTrends {
    private TweetBot TwitterTrends;
    private Scanner word;

    // Constructor: this method allows the TweetBot bot to be used by TwitterTrends.
    // Parameters: TweetBot bot - bot opject from TweetBot.java.
    public TwitterTrends(TweetBot bot){
       TwitterTrends = bot;
    }

    // This method creates a map to store the number of occurances of each word
    // in all of the tweets and returns the word that occures the most.
    // Returns: mostFrequent - most frequent word in all the tweets.
    public String getMostFrequentWord(){
        Map<String, Integer> frequentWords = new HashMap<>();

        for(int i = 0; i < TwitterTrends.numTweets(); i++){
            word = new Scanner(TwitterTrends.nextTweet());
            while(word.hasNext()){
                String nextWord = word.next().toLowerCase();

                if(!frequentWords.containsKey(nextWord)){
                    frequentWords.put(nextWord, 1);
                }else{
                    frequentWords.put(nextWord, frequentWords.get(nextWord) + 1);

                }
            }
        }

        String mostFrequent = findMax(frequentWords);
        return mostFrequent;
    }

    // This method finds the max of all the values in the Map frequentWords.
    // Parameters: Map<String, Integer> frequentWords - map of all words and the number of 
    // occurances per word.
    // Returns: mostFrequent - most frequent word in all the tweets.
    public String findMax(Map<String, Integer> frequentWords){
        int max = 0;
        String mostFrequent = "";
        for (String commonWord : frequentWords.keySet()){
            int max1 = frequentWords.get(commonWord);
            if(max1 > max){
                mostFrequent = commonWord;
                max = max1;
            }
        }
        return mostFrequent;
    }

    // This method finds if 'covid' or 'pandemic' are mentioned in the tweet and then prints
    // out a disclaimer about covid and provides the official CDC website. 
    public void covid(){
        boolean containsCovid = false;

        for(int i = 0; i < TwitterTrends.numTweets(); i++){
            word = new Scanner(TwitterTrends.nextTweet());
            while(word.hasNext()){
                String wordCovid = word.next();
                if(wordCovid.equalsIgnoreCase("covid") || wordCovid.equalsIgnoreCase("pandemic")){
                    containsCovid = true;
                }
            }
        }

        if(containsCovid == true){
            System.out.println("DISCLAIMER: It is best to cross source this information with "
                                    + "official COVID19 data posted by the CDC.");
            System.out.println("Check out the CDC at: https://www.cdc.gov/");
        }
    }
}