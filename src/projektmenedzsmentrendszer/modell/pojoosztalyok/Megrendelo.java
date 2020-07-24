package projektmenedzsmentrendszer.modell.pojoosztalyok;

import java.util.ArrayList;

public class Megrendelo {
    private int azon;
    private String nev;
    private String telSzam;
    private String email;
    private String weboldal;
    private String iranyitoszam;
    private String helyseg;
    private String utcaHazszam;

    public Megrendelo(int azon, String nev, String telSzam, String email, String weboldal, 
            String iranyitoszam, String helyseg, String utcaHazszam) {
        this.azon = azon;
        this.nev = nev;
        this.telSzam = telSzam;
        this.email = email;
        this.weboldal = weboldal;
        this.iranyitoszam = iranyitoszam;
        this.helyseg = helyseg;
        this.utcaHazszam = utcaHazszam;
    }

    public int getAzon() {
        return azon;
    }

    public String getNev() {
        return nev;
    }

    public String getTelSzam() {
        return telSzam;
    }

    public String getEmail() {
        return email;
    }

    public String getWeboldal() {
        return weboldal;
    }

    public String getIranyitoszam() {
        return iranyitoszam;
    }

    public String getHelyseg() {
        return helyseg;
    }

    public String getUtcaHazszam() {
        return utcaHazszam;
    }

    public void setAzon(int azon) {
        this.azon = azon;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setTelSzam(String telSzam) {
        this.telSzam = telSzam;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWeboldal(String weboldal) {
        this.weboldal = weboldal;
    }

    public void setIranyitoszam(String iranyitoszam) {
        this.iranyitoszam = iranyitoszam;
    }

    public void setHelyseg(String helyseg) {
        this.helyseg = helyseg;
    }

    public void setUtcaHazszam(String utcaHazszam) {
        this.utcaHazszam = utcaHazszam;
    }

    @Override
    public String toString() {
        return nev;
    }

    public ArrayList<String> getAdatokStringLista() {
        ArrayList<String> megrendeloAdatok = new ArrayList<>();
        megrendeloAdatok.add(nev);
        megrendeloAdatok.add(telSzam);
        megrendeloAdatok.add(email);
        megrendeloAdatok.add(weboldal);
        megrendeloAdatok.add(iranyitoszam);
        megrendeloAdatok.add(helyseg);
        megrendeloAdatok.add(utcaHazszam);
        return megrendeloAdatok;
    }
}