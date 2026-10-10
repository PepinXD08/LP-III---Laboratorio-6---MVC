package Main;

import Controlador.FutbolController;
import Vista.FutbolView;

public class Main {
    public static void main(String[] args) {
        FutbolController controller = new FutbolController();
        FutbolView view = new FutbolView(controller);

        view.iniciar();
    }
}
