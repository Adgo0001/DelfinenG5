import java.util.ArrayList;

public class Discipline implements Comparable<Discipline>{
    private String type;
    private float bestTime;
    private ArrayList<Event> events = new ArrayList<>();
    private String owner;

    public Discipline(String type, float bestTime, String owner) {
        this.type = type;
        this.bestTime = bestTime;
        this.owner = owner;
    }

    public String toString(){
        return type + ": " + bestTime + " (min,sek)";
    }

    public void createEvent(String eventName, float eventBestTime, int eventPlacement, String disciplineType){
        events.add(new Event(eventName, eventBestTime, eventPlacement, disciplineType));
        compareTime(eventBestTime);
    }

    public ArrayList<Event> getEvents(){
        return events;
    }

    public String getType(){
        return type;
    }
    
    public float getBestTime(){
        return bestTime;
    }

    public String getOwner(){
        return owner;
    }

    public void compareTime(float newTime){
        if (newTime<bestTime) {
            this.bestTime = newTime;   
        }
    }

    public int compareTo(Discipline otherDiscipline){
        return Float.compare(getBestTime(), otherDiscipline.getBestTime());
    }
}
