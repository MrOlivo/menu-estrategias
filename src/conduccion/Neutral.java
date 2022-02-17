package conduccion;

import neumaticos.INeumatico;

public class Neutral extends ITipoConduccion {

    public Neutral() {
        this.wearing = 1.182f;
    }

    @Override
    public String getDescription() {
        return "Desgaste NORMAL por vuelta.";
    }

    @Override
    public float calculateWearing(INeumatico tyre, float currentWear) {
        return currentWear - (tyre.getWearByLap() * this.wearing);
    }
}
