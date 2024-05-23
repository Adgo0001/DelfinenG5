public class Event {
    private String name;
    private float time;
    private int placement;
    private String type;

    public Event(String name, float time, int placement, String type){
        this.name = name;
        this.time = time;
        this.placement = placement;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public float getTime() {
        return time;
    }

    public int getPlacement() {
        return placement;
    }

    public String getType() {
        return type;
    }

}
