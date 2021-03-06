package fr.umlv.fight;

/**
 * My methods for the Arena will be static so I don't need to construct an object Arena
 * But I can still access my methods
 */
public class Arena
{
    private static Robot getWinner(Robot first, Robot second)
    {
        Robot winner;

        if(first.isDead())
            winner = second;
        else
            winner = first;

        return winner;
    }

    private static Robot getLoser(Robot first, Robot second)
    {
        Robot loser;

        if(first.isDead())
            loser = first;
        else
            loser = second;

        return loser;
    }

    public static Robot fight(Robot first, Robot second)
    {
        /**
         * The fight will continue until the IllegalArgumentException is thrown by fire
         */
        while(!first.isDead() && !second.isDead())
        {
            first.fire(second);
            second.fire(first);
        }

        Robot winner = Arena.getWinner(first, second);
        Robot loser = Arena.getLoser(first, second);

        StringBuilder fightStr = new StringBuilder();

        fightStr.append("\n");
        fightStr.append(loser);
        fightStr.append(" has been beaten by ");
        fightStr.append(winner);
        fightStr.append(" !\n");

        System.out.println(fightStr);

        return first;
    }



}
