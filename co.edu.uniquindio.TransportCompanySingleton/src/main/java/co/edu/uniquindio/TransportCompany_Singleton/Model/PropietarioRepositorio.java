package co.edu.uniquindio.TransportCompany_Singleton.Model;

public class PropietarioRepositorio {
    // CRUD PROPIETARIO

    public String buscarPropietarioNombre(String nombre) {
        String resultado = "";
        for (Propietario propietario: getPropietarios()) {
            if(propietario.getNombre().equalsIgnoreCase(nombre)){
                resultado = propietario.toString();
                break;
            }
        }

        return resultado;
    }


    public boolean agregarPropietario(String nombre, String identificacion, String email, String telefono, int edad, double peso) {
        Propietario propietario = obtenerPropietario(identificacion);
        if(propietario == null){
            propietario = new Propietario();
            propietario.setNombre(nombre);
            propietario.setIdentificacion(identificacion);
            propietario.setEmail(email);
            propietario.setTelefono(telefono);
            propietario.setEdad(edad);
            propietario.setPeso(peso);

            getPropietarios().add(propietario);

            return true;
        }else{
            return false;
        }
    }


    public Propietario obtenerPropietario(String identificacion) {
        Propietario propietarioEncontrado = null;
        for (Propietario propietario: getPropietarios()) {
            if(propietario.getIdentificacion().equalsIgnoreCase(identificacion)){
                propietarioEncontrado = propietario;
                break;
            }
        }

        return propietarioEncontrado;
    }


    public boolean eliminarPropietario(String identificacion) {
        Propietario propietario = obtenerPropietario(identificacion);
        if(propietario != null){
            getPropietarios().remove(propietario);
            return true;
        }else{
            return false;
        }
    }


    public boolean actualizarPropietario(String nombre, String identificacion, String email, String telefono, int edad, double peso) {
        Propietario propietario = obtenerPropietario(identificacion);
        if(propietario != null){
            propietario.setNombre(nombre);
            propietario.setIdentificacion(identificacion);
            propietario.setEmail(email);
            propietario.setTelefono(telefono);
            propietario.setEdad(edad);
            propietario.setPeso(peso);

            return true;
        }else{
            return false;
        }
    }
}
