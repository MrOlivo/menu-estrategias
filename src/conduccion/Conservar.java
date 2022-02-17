package conduccion;

import neumaticos.INeumatico;

public class Conservar extends ITipoConduccion {

    public Conservar() {
        this.wearRatio = 1.109f;
    }

    @Override
    public String getDescription() {
        return "Desgaste BAJO por vuelta.";
    }

    @Override
    public float calculateWearing(INeumatico tyre, float currentWear) {
        return currentWear - (tyre.getWearByLap() * this.wearRatio);
    }
}
