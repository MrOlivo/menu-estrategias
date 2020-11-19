package conduccion;

import neumaticos.INeumatico;

public class Atacar extends ITipoConduccion {

    public Atacar() {
        this.desgastePorEstilo = 1.236f;
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