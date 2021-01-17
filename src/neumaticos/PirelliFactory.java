package neumaticos;

public class PirelliFactory {
    public static INeumatico getTyre(String compound) {
        compound = compound.toLowerCase();

        if (compound.equals("super soft")) {
            return new SuperBlando();
        } else if (compound.equals("ultra soft")) {
            return new UltraBlando();
        } else {
            return new Blando();
        }
    }
}
