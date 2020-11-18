package sample;

public class Registro {
    private int id;
    private String desgaste;

    public Registro(int id, float desgaste) {
        this.id = id;
        this.desgaste = formatear(desgaste);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesgaste() {
        return desgaste;
    }

    public void setDesgaste(float desgaste) {
        this.desgaste = formatear(desgaste);
    }

    private String formatear(float n){
        return String.format("%.2f", n);
    }
}
