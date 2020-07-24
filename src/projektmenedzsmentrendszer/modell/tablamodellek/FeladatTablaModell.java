package projektmenedzsmentrendszer.modell.tablamodellek;

import java.sql.Date;
import projektmenedzsmentrendszer.modell.pojoosztalyok.Feladat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import static projektmenedzsmentrendszer.modell.tablamodellek.DatumFormazo.HOSSZU_DATUM;

public class FeladatTablaModell extends AbstractTableModel implements DatumFormazo{
    public static final int OBJECT_OSZLOP = -1;
    private static final int TARGY_OSZLOP = 0;
    private static final int HATARIDO_DATUM_OSZLOP = 1;
    private static final int FELELOS_OSZLOP = 2;
    private static final int PROJEKT_OSZLOP = 3;
    private static final int STATUSZ_OSZLOP = 4;
    
    public String[] oszlopNevek = {"Tárgy", "Határidő dátuma", "Felelős", "Projekt", "Státusz"};
    private ArrayList<Feladat> feladatLista;

    public FeladatTablaModell() {
        this.feladatLista = new ArrayList<>();
    }
    
    public FeladatTablaModell(ArrayList<Feladat> feladatLista) {
        this.feladatLista = feladatLista;
    }

    @Override
    public int getColumnCount() {
        return oszlopNevek.length;
    }

    @Override
    public int getRowCount() {
        return feladatLista.size();
    }

    @Override
    public String getColumnName(int oszlop) {
        return oszlopNevek[oszlop];
    }

    @Override
    public Object getValueAt(int sor, int oszlop) {
        Feladat aktFeladat;
        if(feladatLista.size() > 0){
             aktFeladat = feladatLista.get(sor);
        }else{
            return "";
        }

        switch (oszlop) {
            case TARGY_OSZLOP:
                return aktFeladat.getFeladatTargya();
            case HATARIDO_DATUM_OSZLOP:
                return HOSSZU_DATUM.format(Date.valueOf(aktFeladat.getHataridoDatum()));
            case FELELOS_OSZLOP:
                return aktFeladat.getFelelos().getNev();
            case PROJEKT_OSZLOP:
                return aktFeladat.getProjekt().getNev();
            case STATUSZ_OSZLOP:
                return aktFeladat.getStatuszNev();
            case OBJECT_OSZLOP:
                return aktFeladat;
            default:
                return aktFeladat.getFeladatTargya();
        }
    }

    @Override
    public Class getColumnClass(int oszlop) {
        return getValueAt(0, oszlop).getClass();
    }

    public String[] getOszlopNevek() {
        return oszlopNevek;
    }

    public ArrayList<Feladat> getFeladatLista() {
        return feladatLista;
    }
}