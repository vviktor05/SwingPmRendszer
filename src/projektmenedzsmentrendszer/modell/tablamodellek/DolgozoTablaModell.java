package projektmenedzsmentrendszer.modell.tablamodellek;

import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import projektmenedzsmentrendszer.modell.pojoosztalyok.Dolgozo;
import static projektmenedzsmentrendszer.modell.tablamodellek.DatumFormazo.HOSSZU_DATUM;
import static projektmenedzsmentrendszer.modell.tablamodellek.DatumFormazo.ROVID_DATUM_IDO_ADATBAZIS;

public class DolgozoTablaModell extends AbstractTableModel implements DatumFormazo{
    public static final int OBJECT_OSZLOP = -1;
    private static final int ID_OSZLOP = 0;
    private static final int NEV_OSZLOP = 1;
    private static final int BEOSZTAS_OSZLOP = 2;
    private static final int FEJLESZTESI_TERULET_OSZLOP = 3;
    private static final int SKILL_OSZLOP = 4;
    private static final int KEZDES_DATUM_OSZLOP = 5;
    private static final int TEL_SZAM_OSZLOP = 6;
    private static final int UTOLSO_BEJELENTKEZES_DATUM_OSZLOP = 7;

    public String[] oszlopNevek = {"ID", "Dologzó neve", "Beosztás", "Fejlesztési terület", "Skill", "Kezdés dátuma", "Telefonszám", "Utolsó belépés"};
    private ArrayList<Dolgozo> dolgozoLista;
    Date datum;
    
    public DolgozoTablaModell() {
        this.dolgozoLista = new ArrayList<>();
    }
    
    public DolgozoTablaModell(ArrayList<Dolgozo> dolgozoLista) {
        this.dolgozoLista = dolgozoLista;
    }

    @Override
    public int getColumnCount() {
        return oszlopNevek.length;
    }

    @Override
    public int getRowCount() {
        return dolgozoLista.size();
    }

    @Override
    public String getColumnName(int oszlop) {
        return oszlopNevek[oszlop];
    }

    @Override
    public Object getValueAt(int sor, int oszlop) {
        Dolgozo aktDolgozo;
        if(dolgozoLista.size() > 0){
             aktDolgozo = dolgozoLista.get(sor);
        }else{
            return "";
        }

        switch (oszlop) {
            case ID_OSZLOP:
                return aktDolgozo.getAzon();
            case NEV_OSZLOP:
                return aktDolgozo.getNev();
            case BEOSZTAS_OSZLOP:
                return aktDolgozo.getBeosztasNev();
            case FEJLESZTESI_TERULET_OSZLOP:
                return aktDolgozo.getfTeruletNev();
            case SKILL_OSZLOP:
                return aktDolgozo.getSkillNev();
            case KEZDES_DATUM_OSZLOP:
                return HOSSZU_DATUM.format(java.sql.Date.valueOf(aktDolgozo.getKezdesDatum()));
            case TEL_SZAM_OSZLOP:
                return aktDolgozo.getTelSzam();
            case UTOLSO_BEJELENTKEZES_DATUM_OSZLOP:
                if (aktDolgozo.getUtolsoBejelentkezesDatum() != null) {
                    try {
                        datum = ROVID_DATUM_IDO_ADATBAZIS.parse(aktDolgozo.getUtolsoBejelentkezesDatum());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {
                    return "";
                }
                return HOSSZU_DATUM_IDO.format(datum);
            case OBJECT_OSZLOP:
                return aktDolgozo;
            default:
                return aktDolgozo.getNev();
        }
    }

    @Override
    public Class getColumnClass(int oszlop) {
        return getValueAt(0, oszlop).getClass();
    }
}