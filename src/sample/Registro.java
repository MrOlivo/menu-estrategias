package sample;

public class Registro {
    private int id;
    private String wear;

    public Registro(int id, float wear) {
        this.id = id;
        this.wear = toString(wear);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWear() {
        return wear;
    }

    public void setWear(float wear) {
        this.wear = toString(wear);
    }

    private String toString(float n){
        return String.format("%.2f", n);
    }
}
