package conduccion;

import neumaticos.INeumatico;

public class Atacar implements ITipoConduccion {

    float desgastePorEstilo;

    public Atacar() {
        this.desgastePorEstilo = 1.450f;
    }

    @Override
    public String obtenerDescripcion() {
        return "Desgaste ALTO por vuelta.";
    }

    @Override
    public float calcularDesgaste(INeumatico neumatico, float desgasteActual) {
        return desgasteActual - (neumatico.getDesgastePorVuelta() * desgastePorEstilo);
    }
}