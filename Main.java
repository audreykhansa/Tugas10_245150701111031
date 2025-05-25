import java.util.*; 

public class Main {
    public static void main(String[] args) {

        Team teamA = new Team("Tim A");
        Team teamB = new Team("Tim B");

        teamA.addPlayer(new Player(168, 50));
        teamA.addPlayer(new Player(170, 60));
        teamA.addPlayer(new Player(165, 56));
        teamA.addPlayer(new Player(168, 55));
        teamA.addPlayer(new Player(172, 60));
        teamA.addPlayer(new Player(170, 70));
        teamA.addPlayer(new Player(169, 66));
        teamA.addPlayer(new Player(165, 56));
        teamA.addPlayer(new Player(171, 72));
        teamA.addPlayer(new Player(166, 56));

        teamB.addPlayer(new Player(170, 66));
        teamB.addPlayer(new Player(167, 60));
        teamB.addPlayer(new Player(165, 59));
        teamB.addPlayer(new Player(166, 58));
        teamB.addPlayer(new Player(168, 58));
        teamB.addPlayer(new Player(175, 71));
        teamB.addPlayer(new Player(172, 68));
        teamB.addPlayer(new Player(171, 68));
        teamB.addPlayer(new Player(168, 65));
        teamB.addPlayer(new Player(169, 60));

        System.out.println("== Data Awal Tim A ==");
        teamA.printAllPlayers();

        System.out.println("== Data Awal Tim B ==");
        teamB.printAllPlayers();

        System.out.println("== Urutan Tinggi Ascending ==");
        teamA.sortByHeight(true);
        teamB.sortByHeight(true);

        System.out.println("== Urutan Tinggi Descending ==");
        teamA.sortByHeight(false);
        teamB.sortByHeight(false);

        System.out.println("== Urutan Berat Ascending ==");
        teamA.sortByWeight(true);
        teamB.sortByWeight(true);

        System.out.println("== Urutan Berat Descending ==");
        teamA.sortByWeight(false);
        teamB.sortByWeight(false);

        System.out.println("== Nilai Max dan Min ==");
        teamA.printMaxMin();
        teamB.printMaxMin();

        Team teamC = new Team("Tim C");
        teamC.copyFrom(teamB);
        System.out.println("== Data Tim C (copy Tim B) ==");
        teamC.printAllPlayers();

        System.out.println("== Binary Search ==");
        teamB.binarySearchHeight(168);
        teamB.binarySearchHeight(160);

        teamA.binarySearchWeight(56);
        teamA.binarySearchWeight(53);

        System.out.println("== Cek Duplikat Tinggi/Berat ==");
        System.out.println("Terdapat pemain dengan tinggi yang sama pada Tim A dan Tim B: " + Team.hasSameHeight(teamA, teamB));
        System.out.println("Terdapat pemain dengan berat yang sama pada Tim A dan Tim B: " + Team.hasSameWeight(teamA, teamB));
    }
}
