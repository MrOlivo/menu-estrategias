package conduccion;

import neumaticos.INeumatico;

public class Conservar extends ITipoConduccion {

    public Conservar() {
        this.desgastePorEstilo = 1.109f;
    }

    @Override
    public String obtenerDescripcion() {
        return "Desgaste BAJO por vuelta.";
    }

    @Override
    public float calcularDesgaste(INeumatico neumatico, float desgasteActual) {
        return desgasteActual - (neumatico.getDesgastePorVuelta() * desgastePorEstilo);
    }
}
