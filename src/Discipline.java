import java.util.ArrayList;

public class Discipline {
    private String type;
    private float bestTime;
    private ArrayList<Event> events = new ArrayList<>();

    public Discipline(String type, float bestTime) {
        this.type = type;
        this.bestTime = bestTime;
    }

    public String toString(){
        return type + ": " + bestTime + " (min,sek)";
    }

    public void createEvent(String eventType, float eventBestTime, int eventPlacement, String disciplineType){
        events.add(new Event(eventType, eventBestTime, eventPlacement, disciplineType));
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
}
