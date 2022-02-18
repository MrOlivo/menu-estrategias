package conduccion;

public class Atacar extends ITipoConduccion {

    public Atacar() {
        this.wearRatio = 1.236f;
    }

    @Override
    public String getDescription() {
        return "Desgaste ALTO por vuelta.";
    }
}