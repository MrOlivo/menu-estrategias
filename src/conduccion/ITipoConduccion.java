package conduccion;

import neumaticos.INeumatico;

public interface ITipoConduccion {
    String obtenerDescripcion();

    float calcularDesgaste(INeumatico neumatico, float desgasteActual);
}
