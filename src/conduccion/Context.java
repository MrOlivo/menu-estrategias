package conduccion;

import neumaticos.INeumatico;

public class Context {
    ITipoConduccion tipo_conduccion;

    public Context() {
    }

    public Context(ITipoConduccion tipo_conduccion) {
        this.tipo_conduccion = tipo_conduccion;
    }

    public void setTipo_conduccion(ITipoConduccion tipo_conduccion) {
        this.tipo_conduccion = tipo_conduccion;
    }

    public String obtenerDescripcion(){
        return tipo_conduccion.obtenerDescripcion();
    }

    public float calcularDesgaste(INeumatico neumatico, float desgasteActual){
        return tipo_conduccion.calcularDesgaste(neumatico, desgasteActual);
    }
}
