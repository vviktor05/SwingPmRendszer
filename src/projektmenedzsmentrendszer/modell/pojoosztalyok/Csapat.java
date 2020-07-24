package projektmenedzsmentrendszer.modell.pojoosztalyok;

public class Csapat {
    private int azon;
    private String nev;
    private Dolgozo csapatvezeto;

    public Csapat(int azon, String nev, Dolgozo csapatvezeto) {
        this.azon = azon;
        this.nev = nev;
        this.csapatvezeto = csapatvezeto;
    }

    public int getAzon() {
        return azon;
    }

    public String getNev() {
        return nev;
    }

    public Dolgozo getCsapatvezeto() {
        return csapatvezeto;
    }

    public void setAzon(int azon) {
        this.azon = azon;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setCsapatvezeto(Dolgozo csapatvezeto) {
        this.csapatvezeto = csapatvezeto;
    }

    @Override
    public String toString() {
        return nev;
    }
}