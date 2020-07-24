package projektmenedzsmentrendszer.modell.tablamodellek;

import projektmenedzsmentrendszer.modell.pojoosztalyok.Megrendelo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MegrendeloTablaModell extends AbstractTableModel{
    public static final int OBJECT_OSZLOP = -1;
    private static final int NEV_OSZLOP = 0;
    private static final int TEL_SZAM_OSZLOP = 1;
    private static final int EMAIL_OSZLOP = 2;
    private static final int WEBOLDAL_OSZLOP = 3;
    private static final int IRANYITOSZAM_OSZLOP = 4;
    private static final int HELYSEG_OSZLOP = 5;
    private static final int UTCA_HAZSZAM_OSZLOP = 6;

    public String[] oszlopNevek = {"Név", "Telefonszám", "E-mail", "Weboldal", "Irányítószám", "Helység", "Utca, házszám"};
    private ArrayList<Megrendelo> megrendeloLista;

    public MegrendeloTablaModell() {
        this.megrendeloLista = new ArrayList<>();
    }
    
    public MegrendeloTablaModell(ArrayList<Megrendelo> megrendeloLista) {
        this.megrendeloLista = megrendeloLista;
    }

    @Override
    public int getColumnCount() {
        return oszlopNevek.length;
    }

    @Override
    public int getRowCount() {
        return megrendeloLista.size();
    }

    @Override
    public String getColumnName(int oszlop) {
        return oszlopNevek[oszlop];
    }

    @Override
    public Object getValueAt(int sor, int oszlop) {
        Megrendelo aktMegrendelo;
        if(megrendeloLista.size() > 0){
             aktMegrendelo = megrendeloLista.get(sor);
        }else{
            return "";
        }

        switch (oszlop) {
            case NEV_OSZLOP:
                return aktMegrendelo.getNev();
            case TEL_SZAM_OSZLOP:
                return aktMegrendelo.getTelSzam();
            case EMAIL_OSZLOP:
                return aktMegrendelo.getEmail();
            case WEBOLDAL_OSZLOP:
                return aktMegrendelo.getWeboldal();
            case IRANYITOSZAM_OSZLOP:
                return aktMegrendelo.getIranyitoszam();
            case HELYSEG_OSZLOP:
                return aktMegrendelo.getHelyseg();
            case UTCA_HAZSZAM_OSZLOP:
                return aktMegrendelo.getUtcaHazszam();
            case OBJECT_OSZLOP:
                return aktMegrendelo;
            default:
                return aktMegrendelo.getNev();
        }
    }

    @Override
    public Class getColumnClass(int oszlop) {
        return getValueAt(0, oszlop).getClass();
    }
    
    public ArrayList<Megrendelo> getMegrendeloLista() {
        return megrendeloLista;
    }

    public String[] getOszlopNevek() {
        return oszlopNevek;
    }
}
