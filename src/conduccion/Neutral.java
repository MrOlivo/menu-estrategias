package conduccion;

import neumaticos.INeumatico;

public class Neutral extends ITipoConduccion {

    public Neutral() {
        this.desgastePorEstilo = 1.182f;
    }

    @Override
    public String obtenerDescripcion() {
        return "Desgaste NORMAL por vuelta.";
    }

    @Override
    public float calcularDesgaste(INeumatico neumatico, float desgasteActual) {
        return desgasteActual - (neumatico.getDesgastePorVuelta() * desgastePorEstilo);
    }
}
