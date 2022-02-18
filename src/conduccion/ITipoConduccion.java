package conduccion;

import neumaticos.INeumatico;

public abstract class ITipoConduccion {
    float wearRatio;

    public abstract String getDescription();

    public float calculateWearing(INeumatico tyre, float currentWear){
        return currentWear - (tyre.getWearByLap() * this.wearRatio);
    };
}
