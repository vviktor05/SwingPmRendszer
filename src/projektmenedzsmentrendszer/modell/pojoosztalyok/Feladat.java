package projektmenedzsmentrendszer.modell.pojoosztalyok;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static projektmenedzsmentrendszer.modell.tablamodellek.DatumFormazo.HOSSZU_DATUM;

public class Feladat {
    private int azon;
    private String feladatTargya;
    private String hataridoDatum;
    private Dolgozo felelos;
    private Projekt projekt;
    private HashMap<Integer, String> statusz;
    private String leiras;

    public Feladat(int azon, String feladatTargya, String hataridoDatum, Dolgozo felelos, Projekt projekt, HashMap<Integer, String> statusz, String leiras) {
        this.azon = azon;
        this.feladatTargya = feladatTargya;
        this.hataridoDatum = hataridoDatum;
        this.felelos = felelos;
        this.projekt = projekt;
        this.statusz = statusz;
        this.leiras = leiras;
    }

    public int getAzon() {
        return azon;
    }

    public String getFeladatTargya() {
        return feladatTargya;
    }

    public String getHataridoDatum() {
        return hataridoDatum;
    }

    public Dolgozo getFelelos() {
        return felelos;
    }

    public void setFelelos(Dolgozo felelos) {
        this.felelos = felelos;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }
    
    public int getStatuszID() {
        Integer id = -1;
        for (Map.Entry<Integer, String> aktFt : statusz.entrySet()) {
            id = aktFt.getKey();
        }  
        return id;
    }
    
    public String getStatuszNev() {
        return statusz.get(getStatuszID());
    }

    public String getLeiras() {
        return leiras;
    }

    public void setAzon(int azon) {
        this.azon = azon;
    }

    public void setFeladatTargya(String feladatTargya) {
        this.feladatTargya = feladatTargya;
    }

    public void setHataridoDatum(String hataridoDatum) {
        this.hataridoDatum = hataridoDatum;
    }

    public void setStatusz(int statuszID, String statuszNev) {
        this.statusz.clear();
        this.statusz.put(statuszID, statuszNev);
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }
    
    public ArrayList<String> getAdatokStringLista(){
        ArrayList<String> feladatAdatok = new ArrayList<>();
        feladatAdatok.add(feladatTargya);
        feladatAdatok.add(HOSSZU_DATUM.format(Date.valueOf(hataridoDatum)));
        feladatAdatok.add(felelos.getNev());
        feladatAdatok.add(projekt.getNev());
        feladatAdatok.add(getStatuszNev());
        return feladatAdatok;
    }

    @Override
    public String toString() {
        return "Feladat{" + "azon=" + azon + ", targy=" + feladatTargya + ", hataridoDatum=" + hataridoDatum + ", felelos=" + statusz + ", projekt=" + projekt + ", statusz=" + statusz + ", leiras=" + leiras + '}';
    }   
}