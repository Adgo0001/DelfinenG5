import java.time.Year;

public class Member {
    private String name;
    private int phoneNumber;
    private boolean active;
    private int birthYear;
    private String ageGroup;
    private boolean competitive;
    private boolean restance;

    public Member(String name, int phoneNumber, boolean active, int birthYear, boolean competitive){
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
        this.restance = false;
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

}
