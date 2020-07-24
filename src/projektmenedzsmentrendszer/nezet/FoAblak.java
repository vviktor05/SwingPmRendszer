package projektmenedzsmentrendszer.nezet;

public interface FoAblak {
    public void infoAblak(String uzenet, String fejlec);
    public int kerdesAblak(String uzenet, String fejlec);
    public void hibaAblak(String uzenet, String fejlec);
    public void jelszovaltPanelAlaphelyzet();
}
