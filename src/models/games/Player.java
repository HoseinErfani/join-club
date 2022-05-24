package models.games;

/**
 * Created by skyle on 07/05/2021.
 */
public class Player {
    private String name;
    private String lastName;
    private long nationalId;
    private int age;
    private String Nationality;

    /**
     * constructor
     *
     * @param name        player name
     * @param lastName    player lastName
     * @param nationalId  player nationalId
     * @param age         player age
     * @param nationality nationality
     */
    public Player(String name, String lastName, long nationalId, int age, String nationality) {
        this.name = name;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.age = age;
        Nationality = nationality;
    }

    /**
     * returning player info
     *
     * @return players info
     */
    @Override
    public String toString() {
        return Game.Color.BLACK_BOLD + "\t\t>\t" +
                String.format("%-13.13s", name) +
                String.format("%-13.13s", lastName) +
                String.format("%-13.13s", nationalId) +
                String.format("%-5.5s", age) +
                String.format("%-15.15s", Nationality) +
                Game.Color.RESET + "\n\n";

    }
}
