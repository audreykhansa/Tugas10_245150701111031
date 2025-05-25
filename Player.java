public class Player implements Comparable<Player> {
    private int height;
    private int weight;

    public Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "Tinggi: " + height + " cm, Berat: " + weight + " kg";
    }

    public int compareTo(Player other) {
        return Integer.compare(this.height, other.height);
    }
}
