package conduccion;

import neumaticos.INeumatico;

public class Conservar implements ITipoConduccion {

    float desgastePorEstilo;

    public Conservar() {
        this.desgastePorEstilo = 1.104f;
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
