import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TeamBeginner {
    String name;
    int points;
    int goalDiff;

    TeamBeginner(String name, int points, int goalDiff) {
        this.name = name;
        this.points = points;
        this.goalDiff = goalDiff;
    }

    public String toString() {
        return name + "(" + points + "," + goalDiff + ")";
    }
}

class LeaderboardBeginner<T> {
    List<T> items = new ArrayList<T>();
    Comparator<? super T> order;

    LeaderboardBeginner(Comparator<? super T> order) {
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

public class LeaderboardDemoBeginner {
    public static void main(String[] args) {
        Comparator<TeamBeginner> byRank = new Comparator<TeamBeginner>() {
            public int compare(TeamBeginner first, TeamBeginner second) {
                if (first.points != second.points) {
                    return Integer.compare(second.points, first.points);
                }
                if (first.goalDiff != second.goalDiff) {
                    return Integer.compare(second.goalDiff, first.goalDiff);
                }
                return first.name.compareTo(second.name);
            }
        };

        LeaderboardBeginner<TeamBeginner> board = new LeaderboardBeginner<TeamBeginner>(byRank);
        board.add(new TeamBeginner("Panthers", 9, 4));
        board.add(new TeamBeginner("Eagles", 9, 6));
        board.add(new TeamBeginner("Cobras", 6, 1));
        board.add(new TeamBeginner("Bisons", 9, 4));

        System.out.println(board.ranking());
    }
}