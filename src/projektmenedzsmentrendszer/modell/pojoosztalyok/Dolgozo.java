package projektmenedzsmentrendszer.modell.pojoosztalyok;

import java.util.HashMap;
import java.util.Map;

public class Dolgozo {
    private int azon;
    private String nev;
    private String jelszo;
    private HashMap<Integer, String> beosztas;
    private HashMap<Integer, String> fTerulet;
    private HashMap<Integer, String> skill;
    private String kezdesDatum;
    private String telSzam;
    private String utolsoBejelentkezesDatum;

    public Dolgozo(int azon, String nev, String jelszo, HashMap<Integer, String> beosztas, HashMap<Integer, String> fTerulet, 
            HashMap<Integer, String> skill, String kezdesDatum, 
            String telSzam, String utolsoBejelentkezesDatum) {
        this.azon = azon;
        this.nev = nev;
        this.jelszo = jelszo;
        this.beosztas = beosztas;
        this.fTerulet = fTerulet;
        this.skill = skill;
        this.kezdesDatum = kezdesDatum;
        this.telSzam = telSzam;
        this.utolsoBejelentkezesDatum = utolsoBejelentkezesDatum;
    }

    public int getAzon() {
        return azon;
    }

    public String getNev() {
        return nev;
    }

    public String getJelszo() {
        return jelszo;
    }

    public int getBeosztasID() {
        Integer id = -1;
        for (Map.Entry<Integer, String> aktFt : beosztas.entrySet()) {
            id = aktFt.getKey();
        }  
        return id;
    }
    
    public String getBeosztasNev() {
        return beosztas.get(getBeosztasID());
    }

    public int getfTeruletID() {
        Integer id = -1;
        for (Map.Entry<Integer, String> aktFt : fTerulet.entrySet()) {
            id = aktFt.getKey();
        }  
        return id;
    }
    
    public String getfTeruletNev() {
        return fTerulet.get(getfTeruletID());
    }

    public int getSkillID() {
        Integer id = -1;
        for (Map.Entry<Integer, String> aktFt : skill.entrySet()) {
            id = aktFt.getKey();
        }  
        return id;
    }
    
    public String getSkillNev() {
        return skill.get(getSkillID());
    }

    public String getKezdesDatum() {
        return kezdesDatum;
    }

    public String getTelSzam() {
        return telSzam;
    }

    public String getUtolsoBejelentkezesDatum() {
        return utolsoBejelentkezesDatum;
    }

    public void setAzon(int azon) {
        this.azon = azon;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public void setBeosztas(int beosztasID, String beosztasNev) {
        this.beosztas.clear();
        this.beosztas.put(beosztasID, beosztasNev);
    }

    public void setfTerulet(int fTeruletID, String fTeruletNev) {
        this.fTerulet.clear();
        this.fTerulet.put(fTeruletID, fTeruletNev);
    }

    public void setSkill(int skillID, String skillNev) {
        this.skill.clear();
        this.skill.put(skillID, skillNev);
    }

    public void setKezdesDatum(String kezdesDatum) {
        this.kezdesDatum = kezdesDatum;
    }

    public void setTelSzam(String telSzam) {
        this.telSzam = telSzam;
    }

    public void setUtolsoBejelentkezesDatum(String utolsoBejelentkezesDatum) {
        this.utolsoBejelentkezesDatum = utolsoBejelentkezesDatum;
    }

    @Override
    public String toString() {
        return nev;
    }
}