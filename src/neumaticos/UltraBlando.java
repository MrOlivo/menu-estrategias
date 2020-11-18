package neumaticos;

public class UltraBlando implements INeumatico {
    private float desgaste_por_vuelta;

    public UltraBlando() {
        this.desgaste_por_vuelta = 20;
    }

    @Override
    public float getDesgastePorVuelta() {
        return desgaste_por_vuelta;
    }
}
