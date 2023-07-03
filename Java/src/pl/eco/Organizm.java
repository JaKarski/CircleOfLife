package pl.eco;

public abstract class Organizm implements Comparable<Organizm>{
    protected int sila, inicjatywa, wiek, x, y;
    protected char symbol;
    protected int poRozmnozeniu;
    protected String nazwa;
    public Swiat moj;
    public boolean czyZyje = true;
    protected abstract void kolizja(int powrot);
    public abstract void akcja();
    public void wiekWzrasta(){
      this.wiek++;
     }
    public void rozmnazanieWzrasta(){
        this.poRozmnozeniu++;
    }
    public boolean obrona(Organizm atujacy){
        return false;
    }

    public int getSila() {
        return sila;
    }
    public void setSila(int sila) {
        this.sila = sila;
    }
    public int getInicjatywa() {
        return inicjatywa;
    }
    public int getPoRozmnozeniu() {
        return poRozmnozeniu;
    }
    public void setInicjatywa(int inicjatywa) {
        this.inicjatywa = inicjatywa;
    }
    public int getWiek() {
        return wiek;
    }
    public void setWiek(int wiek) {
        this.wiek = wiek;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public Swiat getMoj() {
        return moj;
    }
    public void setMoj(Swiat moj) {
        this.moj = moj;
    }
    public boolean isCzyZyje() {
        return czyZyje;
    }
    public void setCzyZyje(boolean czyZyje) {
        this.czyZyje = czyZyje;
    }

    @Override
    public int compareTo(Organizm o){
            int compareResult=Double.compare(this.getInicjatywa(), o.getInicjatywa());
            if(compareResult==0) {
                compareResult = Double.compare(this.getWiek(), o.getWiek());
            }
        return compareResult;
    }

}
