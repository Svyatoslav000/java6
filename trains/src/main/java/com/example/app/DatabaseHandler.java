package com.example.app;

import javafx.scene.control.TextArea;

import java.sql.*;
/**
 * Класс DatabaseHandler это класс для работы с базой данных
 */
public class DatabaseHandler extends Config {
    Connection dbConnectoin;// Объявляем переменную для хранения экземпляра подключения
    /**
     * Метод подключения к базе данных
     *
     * @return экземпляр подключения
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getDbConnectoin() // Этот метод подключения к базе данных
            throws ClassNotFoundException, SQLException {// Указываем строку подключения
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName2;
        Class.forName("com.mysql.cj.jdbc.Driver");// Загружаем драйвер
        dbConnectoin = DriverManager.getConnection(connectionString, dbUser, dbPass);// Устанавливаем соединение и возвращаем его
        return dbConnectoin;
    }
    /**
     * Метод добавления нового поезда в базу данных
     *
     * @param train объект класса Train
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void signUpTrain(Train train) throws SQLException, ClassNotFoundException {// Этот метод добавляет нового поезда в базу данных
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_NAME + "," + Const.USER_Vagon + ","+ Const.USER_Mesta + "," + Const.USER_Type + ")" + "VALUES(?,?,?,?)";// Задаем SQL-запрос для вставки
        PreparedStatement prSt = getDbConnectoin().prepareStatement(insert);// Подготавливаем запрос, используя соединение
        prSt.setString(1, train.getName());// Задаем параметры
        prSt.setString(2, train.getNumOfCarriages());
        prSt.setString(3, train.getSeatsInCarriage());
        prSt.setString(4, train.getType());
        prSt.executeUpdate();// Выполняем запрос
    }
    /**
     * Метод получения информации о поезде из базы данных
     *
     * @param show_Tr объект класса TextArea для вывода полученной информации
     * @return объект класса Train
     */
    public Train getTrains(TextArea show_Tr){// Этот метод получает информацию о поезде из базы данных
        String sql = "SELECT * FROM trains ";
        String ss=new String();
        try (PreparedStatement statement = getDbConnectoin().prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");// Получаем информацию о пользователе из результата запроса
                    String vagon = resultSet.getString("vagon");
                    String mesta = resultSet.getString("mesta");
                    String type = resultSet.getString("type");
                    // Заполняем текстовые поля полученными значениями
                   ss+=(name+";типа "+type + ";количество вагонов" +vagon+";Количество мест "
                            +mesta +"\n");
                }
                show_Tr.setText(ss);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    /**
     * Метод добавления нового рейса в базу данных
     *
     * @param rais объект класса Rais
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void signUpRais(Rais rais) throws SQLException, ClassNotFoundException {// Этот метод добавляет нового рейса в базу данных
        String insert = "INSERT INTO " + Const.USER_TABLE2 + "(" + Const.USER_From + "," + Const.USER_Where + ","+ Const.USER_TimeOt + "," + Const.USER_Datt + "," + Const.USER_timePR + ","+ Const.USER_price + ","+ Const.USER_train + ","+ Const.USER_dataPr+")" + "VALUES(?,?,?,?,?,?,?,?)";// Задаем SQL-запрос для вставки
        PreparedStatement prSt = getDbConnectoin().prepareStatement(insert);// Подготавливаем запрос, используя соединение
        prSt.setString(1, rais.getOtkuda());// Задаем параметры
        prSt.setString(2, rais.getKuda());
        prSt.setString(3, rais.getVrOt());
        prSt.setString(4, rais.getDatOt());
        prSt.setString(5, rais.getVrPr());// Задаем параметры
        prSt.setString(6, rais.getCost());
        prSt.setString(7, rais.getTr());
        prSt.setString(8, rais.getDatPr());
        prSt.executeUpdate();// Выполняем запрос
    }
    /**
     * Метод получения информации о рейсе из базы данных
     *
     * @param futR объект класса TextArea для вывода полученной информации
     * @return объект класса Train
     */
    public Train getRais(TextArea futR){// Этот метод получает информацию о рейсе из базы данных
        String sql = "SELECT dataPr,datt,fromG,whereG,timeOT,timePR,train FROM rais ";
        String ss=new String();
        try (PreparedStatement statement = getDbConnectoin().prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String dataPr = resultSet.getString("dataPr");// Получаем информацию о пользователе из результата запроса
                    String datt = resultSet.getString("datt");
                    String fromG = resultSet.getString("fromG");
                    String whereG = resultSet.getString("whereG");
                    String timeOT = resultSet.getString("timeOT");
                    String timePR = resultSet.getString("timePR");
                    String train = resultSet.getString("train");
                    // Заполняем текстовые поля полученными значениями
                    ss+=(train+";из "+fromG + " в " +whereG+";дата отъезда "
                            +datt +";время отъезда "
                            +timeOT+";дата приезда "
                            +dataPr+";время приезда "
                            +timePR+"\n");
                }
                futR.setText(ss);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}