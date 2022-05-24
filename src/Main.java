import club.Club;
import club.Follower;
import models.games.Game;
import models.games.Player;
import models.news.News;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws InterruptedException, ParseException, IOException {

        //clubs
        Club club1 = new Club("club1");
        Club club2 = new Club("club2");

        //followers
        Follower follower1 = new Follower("follower 1");
        Follower follower2 = new Follower("follower 2");
        Follower follower3 = new Follower("follower 3");

        //following
        follower1.follow(club1, "club match");
        follower1.follow(club2, "match player");
        follower2.follow(club2, "club");
        follower3.follow(club2, "club match player");




        String body = "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem ipsum may be used as a placeholder before final copy is available.";

        System.out.println("\n\n\n************************************** first news ********************************************\n\n\n");

        //set news for club1 first time
        club1.setClubNews("title11", body + "1", "02-11-2020 13:13:13");
        club1.setMatchNews("title11", body + "1", "02-11-2020 13:13:13");
        club1.setPlayerNews("title11", body + "1", "02-11-2020 13:13:13");

        //set news for club2 first time
        club2.setClubNews("title21", body + "2", "02-11-2020 13:13:13");
        club2.setMatchNews("title21", body + "2", "02-11-2020 13:13:13");
        club2.setPlayerNews("title21", body + "2", "02-11-2020 13:13:13");


        //making changes in following and unfollow
        follower1.follow(club1, "club player");
        follower1.unfollow(club2);
        follower2.follow(club2, "club");
        follower3.follow(club2, "player");
        follower3.follow(club1, "club");

        System.out.println("\n\n\n************************************** second news ********************************************\n\n\n");

        //set news for club1 second time
        club1.setClubNews("title12", body + "1", "02-11-2020 13:13:13");
        club1.setMatchNews("title12", body + "1", "02-11-2020 13:13:13");
        club1.setPlayerNews("title12", body + "1", "02-11-2020 13:13:13");

        //set news for club2 second time
        club2.setClubNews("title22", body + "2", "02-11-2020 13:13:13");
        club2.setMatchNews("title22", body + "2", "02-11-2020 13:13:13");
        club2.setPlayerNews("title22", body + "2", "02-11-2020 13:13:13");



        //creating players
        Player player1=new Player("hosein", "ahmadi", 324234234, 32, "iran");
        Player player2=new Player("ali", "ghanbari", 234234234, 25, "iran");
        Player player3=new Player("mohammad", "hoseini", 32423234, 22, "iran");
        Player player4=new Player("reza", "zamani", 324234234, 41, "iran");
        Player player5=new Player("mehran", "mosavi", 324234234, 21, "iran");

        //adding players to clubs
        club2.addPlayer(player1);
        club2.addPlayer(player2);
        club2.addPlayer(player3);
        club2.addPlayer(player4);
        club2.addPlayer(player5);


        System.out.println("\n\n\n************************************** first match ********************************************\n\n\n");

        //setting game first time
        club2.setGame("TeamA", "TeamB", "22-09-2020 18:00:00", "azadi", 90);

        //change players in club
        club2.removePlayer(player5);
        System.out.println("\n\n\n************************************** second match ********************************************\n\n\n");

        //setting game second time
        club2.setGame("TeamA", "TeamC", "30-09-2020 17:00:00", "azadi", 90);


    }


}
