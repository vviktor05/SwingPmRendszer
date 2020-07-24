package projektmenedzsmentrendszer.modell.tablamodellek;

import java.sql.Date;
import projektmenedzsmentrendszer.modell.pojoosztalyok.Projekt;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ProjektTablaModell extends AbstractTableModel implements DatumFormazo {
    public static final int OBJECT_OSZLOP = -1;
    private static final int NEV_OSZLOP = 0;
    private static final int MEGRENDELO_OSZLOP = 1;
    private static final int FEJLESZTESI_TERULET_OSZLOP = 2;
    private static final int MEGRENDELES_DATUM_OSZLOP = 3;
    private static final int HATARIDO_DATUM_OSZLOP = 4;
    private static final int HOL_TART_OSZLOP = 5;
    private static final int PRIORITAS_OSZLOP = 6;
    private static final int PROJEKTVEZETO_OSZLOP = 7;
    private static final int STATUSZ_OSZLOP = 8;

    public String[] oszlopNevek = {"Projekt neve", "Megrendelő", "Fejlesztési terület", "Megrendelés dátuma", "Határidő dátuma", "Hol tart", "Prioritás", "Projektvezető", "Státusz"};
    private ArrayList<Projekt> projektLista;

    public ProjektTablaModell() {
        this.projektLista = new ArrayList<>();
    }

    public ProjektTablaModell(ArrayList<Projekt> projektLista) {
        this.projektLista = projektLista;
    }

    @Override
    public int getColumnCount() {
        return oszlopNevek.length;
    }

    @Override
    public int getRowCount() {
        return projektLista.size();
    }

    @Override
    public String getColumnName(int oszlop) {
        return oszlopNevek[oszlop];
    }

    @Override
    public Object getValueAt(int sor, int oszlop) {
        Projekt aktProjekt;
        if (projektLista.size() > 0) {
            aktProjekt = projektLista.get(sor);
        } else {
            return "";
        }

        switch (oszlop) {
            case NEV_OSZLOP:
                return aktProjekt.getNev();
            case MEGRENDELO_OSZLOP:
                return aktProjekt.getMegrendelo() != null ? aktProjekt.getMegrendelo().getNev() : "";
            case FEJLESZTESI_TERULET_OSZLOP:
                return aktProjekt.getFejlesztesiTeruletNev();
            case MEGRENDELES_DATUM_OSZLOP:
                return HOSSZU_DATUM.format(Date.valueOf(aktProjekt.getMegrendelesDatum()));
            case HATARIDO_DATUM_OSZLOP:
                return HOSSZU_DATUM.format(Date.valueOf(aktProjekt.getHataridoDatum()));
            case HOL_TART_OSZLOP:
                return aktProjekt.getHolTartNev();
            case PRIORITAS_OSZLOP:
                return aktProjekt.getPrioritasNev();
            case PROJEKTVEZETO_OSZLOP:
                return aktProjekt.getProjektvezeto().getNev();
            case STATUSZ_OSZLOP:
                return aktProjekt.getStatuszNev();
            case OBJECT_OSZLOP:
                return aktProjekt;
            default:
                return aktProjekt.getNev();
        }
    }

    @Override
    public Class getColumnClass(int oszlop) {
        return getValueAt(0, oszlop).getClass();
    }

    public ArrayList<Projekt> getProjektLista() {
        return projektLista;
    }

    public String[] getOszlopNevek() {
        return oszlopNevek;
    }
}