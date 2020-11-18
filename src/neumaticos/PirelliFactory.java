package neumaticos;

public class PirelliFactory {
    public static INeumatico ObtenerNeumatico(String compuesto) {
        compuesto = compuesto.toLowerCase();

        if (compuesto.equals("superblando")) {
            return new SuperBlando();
        } else if (compuesto.equals("ultrablando")) {
            return new UltraBlando();
        } else {
            return new Blando();
        }
    }
}
