package conduccion;

import neumaticos.INeumatico;

public class CambiarConduccion {
    private Context context;

    public CambiarConduccion() {
        context = new Context();
    }

    public void ConduccionOfensiva() {
        ITipoConduccion conduccion = new Atacar();
        context.setTipo_conduccion(conduccion);
    }

    public void ConduccionNeutral() {
        ITipoConduccion conduccion = new Neutral();
        context.setTipo_conduccion(conduccion);
    }

    public void ConduccionDefensiva() {
        ITipoConduccion conduccion = new Conservar();
        context.setTipo_conduccion(conduccion);
    }

    public float DesgastePorVuelta(INeumatico n, float d){
        return context.calcularDesgaste(n, d);
    }
}
