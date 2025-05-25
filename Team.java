import java.util.*;

public class Team {
    private String name;
    private ArrayList<Player> players;
    public static final Comparator<Player> BY_WEIGHT = Comparator.comparingInt(Player::getWeight);

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void sortByHeight(boolean ascending) {
        players.sort(ascending ? Comparator.naturalOrder() : Comparator.reverseOrder());
        System.out.println(name + ": ");
        printAllPlayers();
    }

    public void sortByWeight(boolean ascending) {
        players.sort(ascending ? BY_WEIGHT : BY_WEIGHT.reversed());
        System.out.println(name + ": ");
        printAllPlayers();
    }

    public void printMaxMin() {
        int maxHeight = players.stream().mapToInt(Player::getHeight).max().orElse(-1);
        int minHeight = players.stream().mapToInt(Player::getHeight).min().orElse(-1);
        int maxWeight = players.stream().mapToInt(Player::getWeight).max().orElse(-1);
        int minWeight = players.stream().mapToInt(Player::getWeight).min().orElse(-1);
        System.out.println(name + " - Tinggi Max: " + maxHeight + ", Min: " + minHeight);
        System.out.println(name + " - Berat Max: " + maxWeight + ", Min: " + minWeight);
        System.out.println();
    }

    public void copyFrom(Team other) {
        this.players.clear();
        for (Player p : other.players) {
            this.players.add(new Player(p.getHeight(), p.getWeight()));
        }
    }

    public void binarySearchHeight(int targetHeight) {
        List<Integer> heights = new ArrayList<>();
        for (Player p : players) heights.add(p.getHeight());
        Collections.sort(heights);
        int idx = Collections.binarySearch(heights, targetHeight);
        long count = heights.stream().filter(h -> h == targetHeight).count();
        System.out.println(name + " - Tinggi " + targetHeight + ": " + (count > 0 ? count + " pemain" : "Tidak ada"));
        System.out.println();
    }

    public void binarySearchWeight(int targetWeight) {
        List<Integer> weights = new ArrayList<>();
        for (Player p : players) weights.add(p.getWeight());
        Collections.sort(weights);
        int idx = Collections.binarySearch(weights, targetWeight);
        long count = weights.stream().filter(w -> w == targetWeight).count();
        System.out.println(name + " - Berat " + targetWeight + ": " + (count > 0 ? count + " pemain" : "Tidak ada"));
        System.out.println();
    }

    public static boolean hasSameHeight(Team t1, Team t2) {
        Set<Integer> heights1 = new HashSet<>();
        for (Player p : t1.players) heights1.add(p.getHeight());
        for (Player p : t2.players) {
            if (heights1.contains(p.getHeight())) return true;
        }
        return false;
    }

    public static boolean hasSameWeight(Team t1, Team t2) {
        Set<Integer> weights1 = new HashSet<>();
        for (Player p : t1.players) weights1.add(p.getWeight());
        for (Player p : t2.players) {
            if (weights1.contains(p.getWeight())) return true;
        }
        return false;
    }

    public void printAllPlayers() {
        for (Player p : players) {
            System.out.println(p);
        }
        System.out.println();
    }
}
