package conduccion;

import neumaticos.INeumatico;

public class Atacar extends ITipoConduccion {

    public Atacar() {
        this.wearing = 1.236f;
    }

    @Override
    public String getDescription() {
        return "Desgaste ALTO por vuelta.";
    }

    @Override
    public float calculateWearing(INeumatico tyre, float currentWear) {
        return currentWear - (tyre.getWearByLap() * this.wearing);
    }
}