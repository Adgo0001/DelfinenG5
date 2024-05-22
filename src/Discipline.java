public class Discipline {
    private String type;
    private float bestTime;

    public Discipline(String type, float bestTime) {
        this.type = type;
        this.bestTime = bestTime;
    }

    public String toString(){
        return type + ": " + bestTime + " (min,sek)";
    }
}
