package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Главный класс запускающий приложение
 */
public class HelloApplication extends Application {
    /**
     * Метод start() запускает приложение
     * @param stage основное окно приложения
     * @throws IOException если файл fxml не найден
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * главный метод запускающий приложение
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}