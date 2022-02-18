package conduccion;

public class Conservar extends ITipoConduccion {

    public Conservar() {
        this.wearRatio = 1.109f;
    }

    @Override
    public String getDescription() {
        return "Desgaste BAJO por vuelta.";
    }
}
