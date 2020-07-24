package projektmenedzsmentrendszer.modell.pojoosztalyok;

public class ProjektCsapat {
    Projekt projekt;
    Csapat csapat;

    public ProjektCsapat(Projekt projekt, Csapat csapat) {
        this.projekt = projekt;
        this.csapat = csapat;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }

    public Csapat getCsapat() {
        return csapat;
    }

    public void setCsapat(Csapat csapat) {
        this.csapat = csapat;
    }

    @Override
    public String toString() {
        return "ProjektCsapat{" + "projekt=" + projekt + ", csapat=" + csapat + '}';
    }    
}