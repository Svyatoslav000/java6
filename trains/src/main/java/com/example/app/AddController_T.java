/**
 * * Класс AddController_T является контроллером для экрана addTrain.fxml.
 * Он обрабатывает регистрацию нового поезда, выборку и отображение информации о поездах из базы данных
 * и навигацию на главную страницу.
 */
package com.example.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AddController_T {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Add_T_Name;

    @FXML
    private TextField Add_T_kolM;

    @FXML
    private TextField Add_T_kolV;

    @FXML
    private TextField Add_T_type;

    @FXML
    private Button addTr;

    @FXML
    private Button on_mainP;

    @FXML
    private Button show_T_button;

    @FXML
    private TextArea show_Tr;
    /**
     * Этот метод вызывается при инициализации.
     * Он настраивает обработчики событий для кнопок
     */
    @FXML
    void initialize() {
        addTr.setOnAction(event -> {
            signUpNewUser();

        });
        show_T_button.setOnAction(event -> {
            DatabaseHandler dbHandler = new DatabaseHandler();// Создание объекта класса DatabaseHandler для работы с базой данных
            dbHandler.getTrains(show_Tr);// Вызов метода getUser с параметрами для поиска информации о пользователе в базе данных
        });

        on_mainP.setOnAction(event -> {
            on_mainP.getScene().getWindow().hide();

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
     * Этот метод обрабатывает регистрацию нового поезда путем извлечения полей ввода c экрана,
     * проверки ввода, создания нового объекта Train и попытки зарегистрировать его в базе данных.
     * В случае успеха он переходит на главную страницу.
     */
    private void signUpNewUser() {// Метод регистрации нового поезда
        DatabaseHandler dbHandler = new DatabaseHandler();// Создание объекта класса DatabaseHandler для работы с базой данных
        String nameText = Add_T_Name.getText().trim();// Получение значений полей для регистрации из формы
        String kolMText = Add_T_kolM.getText().trim();
        String kolVText = Add_T_kolV.getText().trim();
        String typeText = Add_T_type.getText().trim();
        if (!nameText.equals("") && !kolMText.equals("") && !kolVText.equals("") && !typeText.equals("") && isNumeric(kolVText) &&isNumeric(kolMText) && !isNumeric(nameText) && !isNumeric(typeText)) {// Проверка заполнения полей и валидности данных
            Train train = new Train(nameText, typeText, kolVText, kolMText);// Создание объекта пользователя

            addTr.getScene().getWindow().hide();

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
            try {// Попытаться зарегистрировать нового поезда в базе данных
                dbHandler.signUpTrain(train);
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
