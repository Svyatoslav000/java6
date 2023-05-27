package com.example.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Главный класс
 */
public class MainApplication extends Application {

    /**
     * Метод start() запускает приложение
     * @param stage основное окно приложения
     * @throws IOException если файл fxml не найден
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Главный метод, который запускает приложение
     */
    public static void main(String[] args) {
        launch();
    }
}