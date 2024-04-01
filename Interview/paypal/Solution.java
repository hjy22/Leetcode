package Interview.paypal;

import java.util.*;

class Acquaintance{
    String friendName;
    public Acquaintance(String friendName) {
        this.friendName = friendName;
    }
    public void getStatus(){
        System.out.println(friendName);
    }
}

class Friend extends Acquaintance{
    String name;
    String homeTown;
    public Friend(String name,String homeTown) {
        super(name);
        this.name = name;
        this.homeTown = homeTown;
    }
    public void getStatus(){
        System.out.println(name+" is a friend and he is from "+homeTown+".");
    }
}

class BestFriend extends Friend{
    String name;
    String homeTown;
    String favoriteSong;
    public BestFriend(String name,String homeTown,String favoriteSong) {
        super(name,homeTown);
        this.name = name;
        this.homeTown = homeTown;
        this.favoriteSong = favoriteSong;
    }
    public void getStatus(){
        System.out.println(name+" is my best friend. He is from "+homeTown+" and his favorite song is "+favoriteSong+".");
    }
}

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String sub = sc.nextLine();
        int t = Integer.parseInt(sub);
        for (int i = 0; i < t; i++) {
            
            String[] input = sc.nextLine().split(" ");

            if(input[0].equals("Acquaintance")) {
                String friendName = input[1];
                Acquaintance acq = new Acquaintance(friendName);
                acq.getStatus();
            } else if (input[0].equals("Friend")) {
                String friendName = input[1];
                String homeTown = input[2];
                Friend frnd = new Friend(friendName, homeTown);
                frnd.getStatus();
            } else if(input[0].equals("BestFriend")) {
                String friendName = input[1];
                String homeTown = input[2];
                String favoriteSong = input[3];
                BestFriend bf = new BestFriend(friendName, homeTown, favoriteSong);
                bf.getStatus();
            }
        }
    }
}