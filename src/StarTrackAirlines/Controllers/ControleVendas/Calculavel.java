package StarTrackAirlines.Controllers.ControleVendas;

public interface Calculavel<T, V> {
    public double calcular(T object1, V object2);
}
