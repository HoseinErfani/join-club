package models.games;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by skyle on 07/05/2021.
 */
public class Game {
    enum Color {
        //Color end string, color reset
        RESET("\033[0m"),

        // Regular Colors. Normal color, no bold, background color etc.
        BLACK("\033[0;30m"),    // BLACK
        RED("\033[0;31m"),      // RED
        GREEN("\033[0;32m"),    // GREEN
        YELLOW("\033[0;33m"),   // YELLOW
        BLUE("\033[0;34m"),     // BLUE
        MAGENTA("\033[0;35m"),  // MAGENTA
        CYAN("\033[0;36m"),     // CYAN
        WHITE("\033[0;37m"),    // WHITE

        // Bold
        BLACK_BOLD("\033[1;30m"),   // BLACK
        RED_BOLD("\033[1;31m"),     // RED
        GREEN_BOLD("\033[1;32m"),   // GREEN
        YELLOW_BOLD("\033[1;33m"),  // YELLOW
        BLUE_BOLD("\033[1;34m"),    // BLUE
        MAGENTA_BOLD("\033[1;35m"), // MAGENTA
        CYAN_BOLD("\033[1;36m"),    // CYAN
        WHITE_BOLD("\033[1;37m"),   // WHITE


        // High Intensity
        BLACK_BRIGHT("\033[0;90m"),     // BLACK
        RED_BRIGHT("\033[0;91m"),       // RED
        GREEN_BRIGHT("\033[0;92m"),     // GREEN
        YELLOW_BRIGHT("\033[0;93m"),    // YELLOW
        BLUE_BRIGHT("\033[0;94m"),      // BLUE
        MAGENTA_BRIGHT("\033[0;95m"),   // MAGENTA
        CYAN_BRIGHT("\033[0;96m"),      // CYAN
        WHITE_BRIGHT("\033[0;97m");  // WHITE


        private final String code;

        Color(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }

    }


    private String teamName;
    private String OpposingTeam;
    private Date matchDate;
    private String CompetitionVenue;//match location
    private int raceTime;//match time
    //to reform date
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    /**
     * constructor
     *
     * @param teamName         game teamName
     * @param opposingTeam     game opposingTeam
     * @param matchDate        game matchDate
     * @param competitionVenue game competitionVenue
     * @param raceTime         game raceTime
     * @throws ParseException
     */
    public Game(String teamName, String opposingTeam, String matchDate, String competitionVenue, int raceTime) throws ParseException {
        this.teamName = teamName;
        OpposingTeam = opposingTeam;
        this.matchDate = sdf.parse(matchDate);
        CompetitionVenue = competitionVenue;
        this.raceTime = raceTime;
    }

    public String getMatchDate() {
        return sdf.format(matchDate);
    }

    /**
     * returning game info
     *
     * @return game info
     */
    @Override
    public String toString() {
        return Color.RED_BOLD + "\n\t----=====::::Game::::=====----\n" +
                Color.BLUE_BOLD
                + "\tteam name         : " + teamName + "\n" +
                "\tOpposing team     : " + OpposingTeam + "\n" +
                "\tmatch date        : " + getMatchDate() + "\n" +
                "\tCompetition venue : " + CompetitionVenue + "\n" +
                "\trace time         : " + raceTime + Color.RESET;

    }
}
