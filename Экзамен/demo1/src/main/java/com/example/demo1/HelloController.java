package com.example.demo1;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Класс HelloController отвечает за управление поведением элементов графического интерфейса в приложении. Он единственный и отвечает за главный функционал.
 * Он берет информацию о каталоге из текстового поля и записывает все файлы в область
 */
public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea katalogsID;

    @FXML
    private TextField p_id;

    @FXML
    private Button r_on_main;

    /**
     * Инициализирует контроллер.
     * настраивает обработчик событий для кнопки
     */
    @FXML
    void initialize() {
        r_on_main.setOnAction(e -> {
            String directoryPath = p_id.getText();
            StringBuilder sb = new StringBuilder();
            File directory = new File(directoryPath);
            if (directory.exists() && directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            sb.append(file.getName()).append("\n");
                        }
                    }
                }
            }
            katalogsID.setText(sb.toString());
            }
        );


    }
}
