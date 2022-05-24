package club;

import models.games.Game;
import models.games.Player;
import models.news.News;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Club {

    //this club name
    private String clubName;

    //players list
    private List<Player> players = new ArrayList<>();
    //games list
    private List<Game> games = new ArrayList<>();

    //the news
    private News clubNews;
    private News matchNews;
    private News playerNews;

    // to store followers
    private List<Observer> observers = new ArrayList<Observer>();


    /**
     * adding player
     * @param player player
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * removing player
     * @param player player
     */
    public void removePlayer(Player player) {
        players.remove(player);
    }

    /**
     * setting game
     * @param teamName game team Name
     * @param opposingTeam game opposing Team
     * @param matchDate game match Date
     * @param competitionVenue game competition Venue
     * @param raceTime game race Time
     * @throws ParseException
     */
    public void setGame(String teamName, String opposingTeam, String matchDate, String competitionVenue, int raceTime) throws ParseException {
        Game game = new Game(teamName, opposingTeam, matchDate, competitionVenue, raceTime);

        games.add(game);
        //notice this game to followers
        notifyGameObservers(players, game);
    }


    public String getClubName() {
        return clubName;
    }

    //constructor
    public Club(String clubName) {
        this.clubName = clubName;
    }


    public News getClubNews() {
        return clubNews;
    }

    /**
     * setting a club news
     *
     * @param title    tittle of news
     * @param body     body of news
     * @param dateTime date and time of news
     * @throws ParseException exception
     */
    public void setClubNews(String title, String body, String dateTime) throws ParseException {

        this.clubNews = new News(title, body, dateTime);
        //notice this club news to followers
        notifyClubObservers();
    }

    public News getMatchNews() {
        return matchNews;
    }

    /**
     * setting a match news
     *
     * @param title    tittle of news
     * @param body     body of news
     * @param dateTime date and time of news
     * @throws ParseException exception
     */
    public void setMatchNews(String title, String body, String dateTime) throws ParseException {
        this.matchNews = new News(title, body, dateTime);
        //notice this Match news to followers
        notifyMatchObservers();
    }

    public News getPlayerNews() {
        return playerNews;
    }

    /**
     * setting a Player news
     *
     * @param title    tittle of news
     * @param body     body of news
     * @param dateTime date and time of news
     * @throws ParseException exception
     */
    public void setPlayerNews(String title, String body, String dateTime) throws ParseException {
        this.playerNews = new News(title, body, dateTime);
        //notice this Player news to followers
        notifyPlayerObservers();
    }


    /**
     * takes a observer as follower and stores that
     *
     * @param observer follower
     */
    public void attach(Observer observer) {

        observers.add(observer);

    }

    /**
     * takes a observer as follower and removes that from followers list
     *
     * @param observer follower
     */
    public void detach(Observer observer) {

        observers.remove(observer);

    }


    /**
     * notice Club news to all followers
     * calling updateClubNews method of all followers
     */
    private void notifyClubObservers() {
        for (Observer observer : observers) {

            observer.updateClubNews(this);

        }


    }

    /**
     *  notice Match news to all followers
     * calling updateMatchNews method of all followers
     */
    private void notifyMatchObservers() {
        for (Observer observer : observers) {

            observer.updateMatchNews(this);

        }


    }

    /**
     *  notice player news to all followers
     * calling updatePlayerNews method of all followers
     */
    private void notifyPlayerObservers() {
        for (Observer observer : observers) {

            observer.updatePlayerNews(this);

        }


    }

    /**
     * notice game to all followers
     * calling notifyGameObservers method of all followers
     * @param players players list
     * @param game this game
     */
    private void notifyGameObservers(List<Player> players, Game game) {
        for (Observer observer : observers) {

            observer.updateGame(players, game, this);

        }
    }

}