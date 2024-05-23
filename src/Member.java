import java.time.Year;
import java.util.ArrayList;

public class Member {
    private String name;
    private int phoneNumber;
    private boolean active;
    private int birthYear;
    private String ageGroup;
    private boolean competitive;
    private boolean restance;
    private String trainer;
    private ArrayList<Discipline> disciplines = new ArrayList<>();

    public Member(String name, int phoneNumber, boolean active, int birthYear){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.birthYear = birthYear;

        int year = Year.now().getValue();
        int age = year - birthYear;

        if (age < 18) {
            this.ageGroup = "Junior";
        } else if (age < 60) {
            this.ageGroup = "Senior";
        } else {
            this.ageGroup = "Pensionist";
        }
        this.competitive = false;
        this.restance = false;
        this.trainer = "Ingen træner";
    }

    public Member(String name, int phoneNumber, boolean active, int birthYear, boolean competitive, boolean restance, String trainer) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.birthYear = birthYear;

        int year = Year.now().getValue();
        int age = year - birthYear;

        if (age < 18) {
            this.ageGroup = "Junior";
        } else if (age < 60) {
            this.ageGroup = "Senior";
        } else {
            this.ageGroup = "Pensionist";
        }
        this.competitive = competitive;
        this.restance = restance;
        this.trainer = trainer;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public boolean getActive() {
        return active;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public boolean getCompetitive() {
        return competitive;
    }

    public boolean getRestance() {
        return restance;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setPhoneNumber(int newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public void setActive(boolean newActive) {
        this.active = newActive;
    }

    public void setBirthYear(int newBirthYear) {
        this.birthYear = newBirthYear;
    }

    public void setCompetitive(boolean newCompetitive) {
        this.competitive = newCompetitive;
    }

    public void changeRestance() {
        this.restance = !this.restance;
    }

    public void setTrainer(String newTrainer){
        this.trainer = newTrainer;
    }

    public String getTrainer(){
        return trainer;
    }

    public ArrayList<Discipline> getDisciplines(){
        return disciplines;
    }

    public String toString() {
        String aktiv = "Nej";
        String konkurrence = "Nej";
        if (active) {
            aktiv = "Ja";
        }
        if (competitive) {
            konkurrence = "Ja";
        }
        return "Navn: " + name + "\nTelefonnummer: " + phoneNumber + "\nAktiv: " + aktiv + "\nFødselsår: " + birthYear + "\nKonkurrencesvømmer: " + konkurrence;
    }

    public int calcMemberPrice(int[] priceList) {
        if (!active) {
            return priceList[0];
        } else if (ageGroup == "Junior") {
            return priceList[1];
        } else if (ageGroup == "Senior") {
            return priceList[2];
        } else {
            return priceList[3];
        }
    }

    public void addMemberDiscipline(int valg, float pr) {
        //TODO: Gør så der ikke kan tilføjes mere en end af hver discipline.
        switch (valg) {
            case 1:
                disciplines.add(new Discipline("Butterfly", pr));
                break;
            case 2:
                disciplines.add(new Discipline("Crawl", pr));
                break;
            case 3:
                disciplines.add(new Discipline("Rygcrawl", pr));
                break;
            case 4:
                disciplines.add(new Discipline("Brystsvømning", pr));
                break;
        }
    }
}
