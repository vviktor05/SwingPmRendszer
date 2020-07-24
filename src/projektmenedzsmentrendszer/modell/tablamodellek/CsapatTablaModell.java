package projektmenedzsmentrendszer.modell.tablamodellek;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import projektmenedzsmentrendszer.modell.pojoosztalyok.Csapat;

public class CsapatTablaModell extends AbstractTableModel{
    public static final int OBJECT_OSZLOP = -1;
    private static final int NEV_OSZLOP = 0;
    private static final int CSAPATVEZETO_OSZLOP = 1;
    
    public String[] oszlopNevek = {"Csapat neve", "Csapatvezető"};
    private ArrayList<Csapat> csapatLista;

    public CsapatTablaModell() {
        this.csapatLista = new ArrayList<>();
    }
    
    public CsapatTablaModell(ArrayList<Csapat> csapatLista) {
        this.csapatLista = csapatLista;
    }

    @Override
    public int getColumnCount() {
        return oszlopNevek.length;
    }

    @Override
    public int getRowCount() {
        return csapatLista.size();
    }

    @Override
    public String getColumnName(int oszlop) {
        return oszlopNevek[oszlop];
    }

    @Override
    public Object getValueAt(int sor, int oszlop) {
        Csapat aktCsapat;
        if(csapatLista.size() > 0){
             aktCsapat = csapatLista.get(sor);
        }else{
            return "";
        }

        switch (oszlop) {
            case NEV_OSZLOP:
                return aktCsapat.getNev();
            case CSAPATVEZETO_OSZLOP:
                return aktCsapat.getCsapatvezeto().getNev();
            case OBJECT_OSZLOP:
                return aktCsapat;
            default:
                return aktCsapat.getNev();
        }
    }

    @Override
    public Class getColumnClass(int oszlop) {
        return getValueAt(0, oszlop).getClass();
    }
}