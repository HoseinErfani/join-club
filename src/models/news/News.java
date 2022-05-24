package models.news;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by skyle on 07/05/2021.
 */
public class News {
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

    private String title;
    private String body;
    private Date date;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    /**
     * constructor
     * @param title news title
     * @param body news body
     * @param date news date time
     * @throws ParseException
     */
    public News(String title, String body, String date) throws ParseException {
        this.title = title;
        this.body = body;
        this.date = sdf.parse(date);
    }


    /**
     * wrapping body if it be multiple line
     * @return wrapped news body
     */
    public String getBody() {
        String[] arr = body.split(" ");
        String output = "";
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) % 10 == 0)
                output += Color.RESET + "\n\t║\t" + Color.GREEN_BOLD;
            output += arr[i] + " ";
        }
        return output;
    }

    public String getDate() {
        return sdf.format(date);
    }

    /**
     * returning news info
     *
     * @param newsInfo the news name
     * @return output for console
     */
    public String print(String newsInfo) {
        return Color.MAGENTA_BOLD + "\n\t----=====::::" + newsInfo + "::::=====----\n"
                + "\t" + Color.CYAN_BOLD + title + "\t\t|\t\t" + Color.RED_BOLD + getDate() + "\n" +
                Color.RESET + "\t║\t" + Color.GREEN_BOLD + getBody() +
                Color.MAGENTA_BOLD + "\n\t----=====::::::::::::::::::=====----\n" + "\n\n\n" +
                Color.RESET;


    }


}
