package conduccion;

import neumaticos.INeumatico;

public abstract class ITipoConduccion {
    float wearRatio;

    public abstract String getDescription();

    public abstract float calculateWearing(INeumatico tyre, float currentWear);
}
