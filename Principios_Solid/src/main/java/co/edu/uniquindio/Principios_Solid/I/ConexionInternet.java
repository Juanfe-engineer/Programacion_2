package co.edu.uniquindio.Principios_Solid.I;

public interface ConexionInternet {

    void conectarWifi(String red, String password);
    void desconectarWifi();
    boolean estaConectado();
}
