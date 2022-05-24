package club;

import models.games.Game;
import models.games.Player;

import java.util.List;

/**
 * Created by skyle on 06/05/2021.
 */
public abstract class Observer {


    /**
     * printing news of the club that we have followed
     * @param club  the club that we have followed
     */
    public abstract void updateClubNews(Club club);

    public abstract void updateMatchNews(Club club);

    public abstract void updatePlayerNews(Club club);

    /**
     * printing game news and players list of the club that we have followed
     * @param players players list
     * @param game the game
     * @param club  the club that we have followed
     */
    public abstract void updateGame(List<Player> players, Game game, Club club);

}