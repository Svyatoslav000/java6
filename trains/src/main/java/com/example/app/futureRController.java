/**
 * * Класс futureRController является контроллером для экрана futureR.fxml.
 * Он обрабатывает выборку и отображение информации о рейсах из базы данных
 * и навигацию на главную страницу.
 */
package com.example.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class futureRController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea futR;

    @FXML
    private Button futR_button;

    @FXML
    private Button on_mainF;
    /**
     * Этот метод вызывается при инициализации.
     * Он настраивает обработчики событий для кнопок
     */
    @FXML
    void initialize() {
        futR_button.setOnAction(event -> {
            DatabaseHandler dbHandler = new DatabaseHandler();// Создание объекта класса DatabaseHandler для работы с базой данных
            dbHandler.getRais(futR);// Вызов метода getUser с параметрами для поиска информации о пользователе в базе данных
        });
        on_mainF.setOnAction(event -> {
            on_mainF.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("main.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    }

}
