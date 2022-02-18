package conduccion;

public class Neutral extends ITipoConduccion {

    public Neutral() {
        this.wearRatio = 1.182f;
    }

    @Override
    public String getDescription() {
        return "Desgaste NORMAL por vuelta.";
    }
}
