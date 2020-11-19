package conduccion;

import neumaticos.INeumatico;

public abstract class ITipoConduccion {
    float desgastePorEstilo;

    public abstract String obtenerDescripcion();

    public abstract float calcularDesgaste(INeumatico neumatico, float desgasteActual);
}
