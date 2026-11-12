import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Team {
    String name;
    int points;
    int goalDiff;

    Team(String name, int points, int goalDiff) {
        this.name = name;
        this.points = points;
        this.goalDiff = goalDiff;
    }

    public String toString() {
        return name + "(" + points + "," + goalDiff + ")";
    }
}

class Leaderboard<T> {
    List<T> items = new ArrayList<T>();
    Comparator<? super T> order;

    Leaderboard(Comparator<? super T> order) {
        this.order = order;
    }

    void add(T item) {
        items.add(item);
    }

    List<T> ranking() {
        List<T> sortedItems = new ArrayList<T>(items);
        Collections.sort(sortedItems, order);
        return sortedItems;
    }
}

public class LeaderboardDemo {
    public static void main(String[] args) {
        Comparator<Team> byRank = new Comparator<Team>() {
            public int compare(Team first, Team second) {
                if (first.points != second.points) {
                    return Integer.compare(second.points, first.points);
                }
                if (first.goalDiff != second.goalDiff) {
                    return Integer.compare(second.goalDiff, first.goalDiff);
                }
                return first.name.compareTo(second.name);
            }
        };

        Leaderboard<Team> board = new Leaderboard<Team>(byRank);
        board.add(new Team("Panthers", 9, 4));
        board.add(new Team("Eagles", 9, 6));
        board.add(new Team("Cobras", 6, 1));
        board.add(new Team("Bisons", 9, 4));

        System.out.println(board.ranking());
    }
}