package neumaticos;

public class PirelliFactory {
    public static INeumatico getTyre(String compound) {
        switch (compound.toLowerCase()) {
            case "super-soft":
                return new SuperBlando();
            case "ultra-soft":
                return new UltraBlando();
            default:
                return new Blando();
        }
    }
}
