class Team {
    final String name;
    final int points;
    final int goalDiff;

    Team(String name, int points, int goalDiff) {
        this.name = name;
        this.points = points;
        this.goalDiff = goalDiff;
    }

    @Override
    public String toString() {
        return name + "(" + points + "," + goalDiff + ")";
    }
}

class Leaderboard<T> {
    private final java.util.List<T> items = new java.util.ArrayList<T>();
    private final java.util.Comparator<? super T> order;

    Leaderboard(java.util.Comparator<? super T> order) {
        this.order = order;
    }

    void add(T item) {
        items.add(item);
    }

    java.util.List<T> ranking() {
        java.util.List<T> sortedItems = new java.util.ArrayList<T>(items);
        java.util.Collections.sort(sortedItems, order);
        return sortedItems;
    }
}

public class task5 {
    public static void main(String[] args) {
        java.util.Comparator<Team> byRank = new java.util.Comparator<Team>() {
            @Override
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
