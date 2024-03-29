/**
 * * Класс AddController_T является контроллером для экрана addR.fxml.
 * Он обрабатывает регистрацию нового рейса
 * и навигацию на главную страницу.
 */
package com.example.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class addRController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addR;

    @FXML
    private TextField dataPr;

    @FXML
    private TextField datt;

    @FXML
    private TextField fromG;

    @FXML
    private Button on_mainR;

    @FXML
    private TextField price;

    @FXML
    private TextField timeOT;

    @FXML
    private TextField timePR;

    @FXML
    private TextField train;

    @FXML
    private TextField whereG;
    /**
     * Этот метод вызывается при инициализации.
     * Он настраивает обработчики событий для кнопок
     */
    @FXML
    void initialize() {
        addR.setOnAction(event -> {
            signUpNewR();

        });
        on_mainR.setOnAction(event -> {
            on_mainR.getScene().getWindow().hide();

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
    /**
     * Этот метод обрабатывает регистрацию нового рейса путем извлечения полей ввода c экрана,
     * проверки ввода, создания нового объекта Rais и попытки зарегистрировать его в базе данных.
     * В случае успеха он переходит на главную страницу.
     */
    private void signUpNewR() {// Метод регистрации нового рейса
        DatabaseHandler dbHandler = new DatabaseHandler();// Создание объекта класса DatabaseHandler для работы с базой данных
        String dataPrText = dataPr.getText().trim();// Получение значений полей для регистрации из формы
        String dattText = datt.getText().trim();
        String fromGText = fromG.getText().trim();
        String priceText = price.getText().trim();
        String timeOTText = timeOT.getText().trim();
        String timePRText = timePR.getText().trim();
        String trainText = train.getText().trim();
        String whereGText = whereG.getText().trim();
        if (!dataPrText.equals("") && !dattText.equals("") && !fromGText.equals("") && !priceText.equals("") && !timeOTText.equals("") && !timePRText.equals("") && !whereGText.equals("") && !priceText.equals("") &&isNumeric(priceText) && !isNumeric(whereGText) && !isNumeric(fromGText) && !isNumeric(trainText)) {// Проверка заполнения полей и валидности данных
            Rais rais = new Rais(fromGText, whereGText, timeOTText, timePRText,priceText, dattText, dataPrText, trainText);// Создание объекта рейса

            addR.getScene().getWindow().hide();

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
            try {// Попытаться зарегистрировать нового рейса в базе данных
                dbHandler.signUpRais(rais);
            } catch (SQLException e) {
                throw new RuntimeException(e);// Выбросить исключение, если регистрация не удалась
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);// Выбросить исключение, если класс не найден
            }
        }
    }

    /**
     * Этот метод проверяет, является ли данная строка допустимым целым числом, пытаясь проанализировать ее.
     * @param str Строка для проверки.
     * @return является ли строка допустимым целым числом или нет.
     */
    public static boolean isNumeric(String str) {// Метод для проверки является ли строка числом
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
