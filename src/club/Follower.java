package club;

import models.games.Game;
import models.games.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Follower extends Observer {
    //follower name
    private String name;

    //clubs list which this follower follows them
    private List<Club> clubs = new ArrayList<>();

    //field of news
    private Map<Club, String> subscribeFields = new HashMap<>();

    //constructor
    public Follower(String name) {
        this.name = name;
    }

    /**
     * unfollowing the followed club
     * @param club the club that we have followed
     */
    public void unfollow(Club club) {
        for (int i = 0; i < clubs.size(); i++) {
            //checking if club exists
            if (clubs.get(i) == club) {
                //removing subscribe fields
                this.subscribeFields.remove(club);
                //removing this follower from the list of the club
                clubs.get(i).detach(this);
                //removing the club from clubs list
                clubs.remove(club);
                break;

            }

        }
    }

    /**
     * converting news fields to number
     * @param newsfields news fields as letters
     * @return news fields as number
     */
    private String newsFieldsToNumber(String newsfields) {
        String output = "";

            String[] arr = newsfields.split(" ");
            for (String s : arr) {
                switch (s.toLowerCase()) {
                    case "club":
                        output += "1";
                        break;
                    case "match":
                        output += "2";
                        break;
                    case "player":
                        output += "3";
                        break;
                }
            }


        return output;
    }

    /**
     * following clubs
     * @param club  the club that we have followed
     * @param newsFields  field of news
     */
    public void follow(Club club, String newsFields) {
        //converting fields to number
        String subscribeFields = newsFieldsToNumber(newsFields);


        /*
        checks if we already followed the club
        if true, just changes subscribe fields and return
         */
        for (int i = 0; i < clubs.size(); i++) {
            if (clubs.get(i) == club) {
                this.subscribeFields.put(club, subscribeFields);
                return;
            }

        }
        //to store field of news
        this.subscribeFields.put(club, subscribeFields);
        //adding club to clubs list
        clubs.add(club);
        int lastIndex = this.clubs.size() - 1;
        //asking the club to save us as follower
        clubs.get(lastIndex).attach(this);

    }

    /**
     * printing club news of the club that we have followed
     * @param club the club that we have followed
     */
    @Override
    public void updateClubNews(Club club) {
        String subscribeFields = this.subscribeFields.get(club);
        if (subscribeFields.contains("1")) {
            System.out.println("dear " + name + ",you have news from " + club.getClubName() + club.getClubNews().print("club news"));
        }
    }
    /**
     * printing Match news of the club that we have followed
     * @param club the club that we have followed
     */
    @Override
    public void updateMatchNews(Club club) {
        String subscribeFields = this.subscribeFields.get(club);
        if (subscribeFields.contains("2")) {
            System.out.println("dear " + name + ",you have news from " + club.getClubName() + club.getMatchNews().print("match news"));
        }

    }
    /**
     * printing Player news of the club that we have followed
     * @param club the club that we have followed
     */
    @Override
    public void updatePlayerNews(Club club) {
        String subscribeFields = this.subscribeFields.get(club);
        if (subscribeFields.contains("3")) {
            System.out.println("dear " + name + ",you have news from " + club.getClubName() + club.getPlayerNews().print("player news"));
        }

    }

    /**
     * printing the games that set by clubs
     * @param players players list
     * @param game the game
     * @param club  the club that we have followed
     */
    @Override
    public void updateGame(List<Player> players, Game game, Club club) {
        String output = "dear " + name + ",there is a game set by " + club.getClubName() + game.toString() + "\n\n";
        output += "\t\t-------------------------players----------------------------\n\t\t\t";
        output += String.format("%-13.13s", "name");
        output += String.format("%-13.13s", "last name");
        output += String.format("%-13.13s", "nationalId");
        output += String.format("%-5.5s", "age");
        output += String.format("%-15.15s", "Nationality") + "\n\n";

        for (Player player : players) {
            output += player.toString();
        }
        output += "\t\t------------------------------------------------------------\n\n";
        System.out.println(output);

    }



}