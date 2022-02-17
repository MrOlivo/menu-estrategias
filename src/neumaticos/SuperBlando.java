package neumaticos;

public class SuperBlando implements INeumatico {
    private float desgaste_por_vuelta;

    public SuperBlando() {
        this.desgaste_por_vuelta = 11;
    }

    @Override
    public float getWearByLap() {
        return desgaste_por_vuelta;
    }
}
