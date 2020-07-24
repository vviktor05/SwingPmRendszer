package projektmenedzsmentrendszer.modell.pojoosztalyok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static projektmenedzsmentrendszer.modell.tablamodellek.DatumFormazo.HOSSZU_DATUM;

public class Projekt {
    private int azon;
    private String nev;
    private Megrendelo megrendelo;
    private HashMap<Integer, String> fejlesztesiTerulet;
    private String megrendelesDatum;
    private String hataridoDatum;
    private HashMap<Integer, String> holTart;
    private HashMap<Integer, String> prioritas;
    private Dolgozo projektvezeto;
    private HashMap<Integer, String> statusz;
    private String leiras;

    public Projekt(int azon, String nev, Megrendelo megrendelo, HashMap<Integer, String> fejlesztesiTerulet, String megrendelesDatum,
            String hataridoDatum, HashMap<Integer, String> holTart, HashMap<Integer, String> prioritas, Dolgozo projektvezeto,
            HashMap<Integer, String> statusz, String leiras) {
        this.azon = azon;
        this.nev = nev;
        this.megrendelo = megrendelo;
        this.fejlesztesiTerulet = fejlesztesiTerulet;
        this.megrendelesDatum = megrendelesDatum;
        this.hataridoDatum = hataridoDatum;
        this.holTart = holTart;
        this.prioritas = prioritas;
        this.projektvezeto = projektvezeto;
        this.statusz = statusz;
        this.leiras = leiras;
    }

    public int getAzon() {
        return azon;
    }

    public String getNev() {
        return nev;
    }

    public Megrendelo getMegrendelo() {
        return megrendelo;
    }

    public int getFejlesztesiTeruletID() {
        Integer id = -1;
        for (Map.Entry<Integer, String> aktFt : fejlesztesiTerulet.entrySet()) {
            id = aktFt.getKey();
        }
        return id;
    }

    public String getFejlesztesiTeruletNev() {
        return fejlesztesiTerulet.get(getFejlesztesiTeruletID());
    }

    public String getMegrendelesDatum() {
        return megrendelesDatum;
    }

    public String getHataridoDatum() {
        return hataridoDatum;
    }

    public int getHolTartID() {
        Integer id = -1;
        for (Map.Entry<Integer, String> aktFt : holTart.entrySet()) {
            id = aktFt.getKey();
        }
        return id;
    }

    public String getHolTartNev() {
        return holTart.get(getHolTartID());
    }

    public int getPrioritasID() {
        Integer id = -1;
        for (Map.Entry<Integer, String> aktFt : prioritas.entrySet()) {
            id = aktFt.getKey();
        }
        return id;
    }

    public String getPrioritasNev() {
        return prioritas.get(getPrioritasID());
    }

    public Dolgozo getProjektvezeto() {
        return projektvezeto;
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

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setMegrendelo(Megrendelo megrendelo) {
        this.megrendelo = megrendelo;
    }

    public void setFejlesztesiTerulet(int fejlesztesiTeruletID, String fejlesztesiTeruletNev) {
        this.fejlesztesiTerulet.clear();
        this.fejlesztesiTerulet.put(fejlesztesiTeruletID, fejlesztesiTeruletNev);
    }

    public void setMegrendelesDatum(String megrendelesDatum) {
        this.megrendelesDatum = megrendelesDatum;
    }

    public void setHataridoDatum(String hataridoDatum) {
        this.hataridoDatum = hataridoDatum;
    }

    public void setHolTart(int holTartID, String holTartNev) {
        this.holTart.clear();
        this.holTart.put(holTartID, holTartNev);
    }

    public void setPrioritas(int prioritasID, String prioritasNev) {
        this.prioritas.clear();
        this.prioritas.put(prioritasID, prioritasNev);
    }

    public void setProjektvezeto(Dolgozo projektvezeto) {
        this.projektvezeto = projektvezeto;
    }

    public void setStatusz(int statuszID, String statuszNev) {
        this.statusz.clear();
        this.statusz.put(statuszID, statuszNev);
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }
    
    public ArrayList<String> getAdatokStringLista(){
        ArrayList<String> projektAdatok = new ArrayList<>();
        projektAdatok.add(nev);
        projektAdatok.add(megrendelo != null ? megrendelo.getNev() : "");
        projektAdatok.add(getFejlesztesiTeruletNev());
        projektAdatok.add(HOSSZU_DATUM.format(java.sql.Date.valueOf(megrendelesDatum)));
        projektAdatok.add(HOSSZU_DATUM.format(java.sql.Date.valueOf(hataridoDatum)));
        projektAdatok.add(getHolTartNev());
        projektAdatok.add(getPrioritasNev());
        projektAdatok.add(projektvezeto.getNev());
        projektAdatok.add(getStatuszNev());
        return projektAdatok;
    }

    @Override
    public String toString() {
        return nev;
    }
}