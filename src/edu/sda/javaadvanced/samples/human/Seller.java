package edu.sda.javaadvanced.samples.human;

public class Seller extends Human implements Driver {

    private String branch;
    private String workDestination;
    private String familyDestination;
    private boolean isWorking;

    public Seller(String name, String surname, Gender gender) {
        super(name, surname, gender);
    }

    public String getBranch() {
        return branch;
    }

    /**
     * Nie setter tylko changeBranch BO:
     *  - setter "biznesowo" nic nie mówi, natomiast "change" oznacza "zmień", można
     *  badać przyczynę, mamy większą czytelność kodu
     */
    public void changeBranch(String branch) {
        this.branch = branch;
    }

    public void setWorkDestination(String workDestination) {
        this.workDestination = workDestination;
    }

    public void setFamilyDestination(String familyDestination) {
        this.familyDestination = familyDestination;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public boolean isWorking() {
        return isWorking;
    }

    @Override
    public String driveTo() {
        //tenary operator czyli "jednolinijkowy if"
        return isWorking ? workDestination : familyDestination;
    }
}
