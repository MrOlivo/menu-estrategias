package neumaticos;

public class Blando implements INeumatico {
    private float desgaste_por_vuelta;

    public Blando() {
        this.desgaste_por_vuelta = 9;
    }

    @Override
    public float getWearByLap() {
        return desgaste_por_vuelta;
    }
}
