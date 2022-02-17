package conduccion;

import neumaticos.INeumatico;

public abstract class ITipoConduccion {
    float wearing;

    public abstract String getDescription();

    public abstract float calculateWearing(INeumatico tyre, float currentWear);

    public static ITipoConduccion getDrivingStyle(String opt){
        switch (opt.toLowerCase()) {
            case "keep":
                return new Conservar();
            case "attack":
                return new Atacar();
            default:
                return new Neutral();
        }
    }
}
