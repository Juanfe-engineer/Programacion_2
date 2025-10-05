package co.edu.uniquindio.cafeteria;

import co.edu.uniquindio.cafeteria.Controller.CafeController;
import co.edu.uniquindio.cafeteria.Controller.ObserverVentana1Controller;
import co.edu.uniquindio.cafeteria.Controller.ObserverVentana2Controller;
import co.edu.uniquindio.cafeteria.Model.Observer.CafeteriaObservable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CafeApplication extends Application {

    private CafeteriaObservable cafeteriaObservable;

    @Override
    public void start(Stage primaryStage) throws Exception {

        cafeteriaObservable = new CafeteriaObservable();

        FXMLLoader cafeLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/cafeteria/CafeView.fxml"));
        Parent cafeRoot = cafeLoader.load();
        CafeController cafeController = cafeLoader.getController();
        cafeController.setCafeteriaObservable(cafeteriaObservable);

        Scene cafeScene = new Scene(cafeRoot);
        primaryStage.setTitle("Cafetería UQ - Sistema de Pedidos");
        primaryStage.setScene(cafeScene);
        primaryStage.setX(100);
        primaryStage.setY(100);
        primaryStage.show();

        FXMLLoader observer1Loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/cafeteria/ObserverVentana1.fxml"));
        Parent observer1Root = observer1Loader.load();
        ObserverVentana1Controller observer1Controller = observer1Loader.getController();
        cafeteriaObservable.agregarObservador(observer1Controller);

        Stage observer1Stage = new Stage();
        observer1Stage.setTitle("Monitor de Cocina");
        observer1Stage.setScene(new Scene(observer1Root));
        observer1Stage.setX(650);
        observer1Stage.setY(100);
        observer1Stage.show();

        FXMLLoader observer2Loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/cafeteria/ObserverVentana2.fxml"));
        Parent observer2Root = observer2Loader.load();
        ObserverVentana2Controller observer2Controller = observer2Loader.getController();
        cafeteriaObservable.agregarObservador(observer2Controller);

        Stage observer2Stage = new Stage();
        observer2Stage.setTitle("Monitor de Ventas");
        observer2Stage.setScene(new Scene(observer2Root));
        observer2Stage.setX(100);
        observer2Stage.setY(550);
        observer2Stage.show();

        FXMLLoader videoLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/cafeteria/VideoView.fxml"));
        Parent videoRoot = videoLoader.load();

        Stage videoStage = new Stage();
        videoStage.setTitle("Reproductor de Video");
        videoStage.setScene(new Scene(videoRoot));
        videoStage.setX(650);
        videoStage.setY(550);
        videoStage.show();

        primaryStage.setOnCloseRequest(event -> {
            observer1Stage.close();
            observer2Stage.close();
            videoStage.close();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}