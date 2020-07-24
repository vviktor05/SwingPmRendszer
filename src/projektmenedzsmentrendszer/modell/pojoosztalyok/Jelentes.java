package projektmenedzsmentrendszer.modell.pojoosztalyok;

public class Jelentes {
    private int azon;
    private Projekt projekt;
    private String felvitelDatuma;
    private Dolgozo felvitte;
    private String szoveg;

    public Jelentes(int azon, Projekt projekt, String felvitelDatuma, Dolgozo felvitte, String szoveg) {
        this.azon = azon;
        this.projekt = projekt;
        this.felvitelDatuma = felvitelDatuma;
        this.felvitte = felvitte;
        this.szoveg = szoveg;
    }

    public int getAzon() {
        return azon;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public String getFelvitelDatuma() {
        return felvitelDatuma;
    }

    public Dolgozo getFelvitte() {
        return felvitte;
    }

    public String getSzoveg() {
        return szoveg;
    }

    public void setAzon(int azon) {
        this.azon = azon;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }

    public void setFelvitelDatuma(String felvitelDatuma) {
        this.felvitelDatuma = felvitelDatuma;
    }

    public void setFelvitte(Dolgozo felvitte) {
        this.felvitte = felvitte;
    }

    public void setSzoveg(String szoveg) {
        this.szoveg = szoveg;
    }

    @Override
    public String toString() {
        return "Jelentes{" + "azon=" + azon + ", projekt=" + projekt + ", felvitelDatuma=" + felvitelDatuma + ", felvitte=" + felvitte + ", szoveg=" + szoveg + '}';
    }
}