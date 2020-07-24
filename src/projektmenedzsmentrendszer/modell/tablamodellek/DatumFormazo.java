package projektmenedzsmentrendszer.modell.tablamodellek;

import java.text.SimpleDateFormat;

public interface DatumFormazo {
    SimpleDateFormat ROVID_DATUM = new SimpleDateFormat("yyyy.MM.dd.");
    SimpleDateFormat HOSSZU_DATUM = new SimpleDateFormat("yyyy. MMMM d.");
    SimpleDateFormat HOSSZU_DATUM_IDO = new SimpleDateFormat("yyyy. MMMM d. HH:mm:ss");
    SimpleDateFormat ROVID_DATUM_ADATBAZIS = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat ROVID_DATUM_IDO_ADATBAZIS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat ROVID_DATUM_IDO_FAJLNEV = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
}