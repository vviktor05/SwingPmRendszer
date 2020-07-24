package projektmenedzsmentrendszer.modell.tablamodellek;

import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import projektmenedzsmentrendszer.modell.pojoosztalyok.*;

public class JelentesTablaModell extends AbstractTableModel implements DatumFormazo {
    public static final int OBJECT_OSZLOP = -1;
    private static final int PROJEKT_OSZLOP = 0;
    private static final int FELVITEL_DATUM_OSZLOP = 1;
    private static final int FELVITTE_OSZLOP = 2;

    public String[] oszlopNevek = {"Projekt neve", "Felvitel dátuma", "Felvitte"};
    private ArrayList<Jelentes> jelentesLista;
    private Date datum;

    public JelentesTablaModell() {
        this.jelentesLista = new ArrayList<>();
    }

    public JelentesTablaModell(ArrayList<Jelentes> jelentesLista) {
        this.jelentesLista = jelentesLista;
    }

    @Override
    public int getColumnCount() {
        return oszlopNevek.length;
    }

    @Override
    public int getRowCount() {
        return jelentesLista.size();
    }

    @Override
    public String getColumnName(int oszlop) {
        return oszlopNevek[oszlop];
    }

    @Override
    public Object getValueAt(int sor, int oszlop) {
        Jelentes aktJelentes;
        if (jelentesLista.size() > 0) {
            aktJelentes = jelentesLista.get(sor);
        } else {
            return "";
        }

        switch (oszlop) {
            case PROJEKT_OSZLOP:
                return aktJelentes.getProjekt().getNev();
            case FELVITEL_DATUM_OSZLOP:
                try {
                    datum = ROVID_DATUM_IDO_ADATBAZIS.parse(aktJelentes.getFelvitelDatuma());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return HOSSZU_DATUM_IDO.format(datum);
            case FELVITTE_OSZLOP:
                return aktJelentes.getFelvitte().getNev();
            case OBJECT_OSZLOP:
                return aktJelentes;
            default:
                return aktJelentes.getProjekt().getNev();
        }
    }

    @Override
    public Class getColumnClass(int oszlop) {
        return getValueAt(0, oszlop).getClass();
    }

    public String[] getOszlopNevek() {
        return oszlopNevek;
    }

    public ArrayList<Jelentes> getJelentesLista() {
        return jelentesLista;
    }
}