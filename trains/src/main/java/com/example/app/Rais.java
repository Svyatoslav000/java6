package com.example.app;
/**
 * Класс, описывающий рейсы.
 */
public class Rais {
    /**
     * Создание экземпляра класса Rais.
     * @param otkuda - начальная точка маршрута.
     * @param kuda - конечная точка маршрута.
     * @param vrOt - время отправления рейса.
     * @param vrPr - время прибытия рейса.
     * @param cost - стоимость рейса.
     * @param datOt - дата отправления рейса.
     * @param datPr - дата прибытия рейса.
     * @param tr - поезд.
     */
    public Rais(String otkuda, String kuda, String vrOt, String vrPr, String cost, String datOt, String datPr, String tr) {
        this.otkuda = otkuda;
        this.kuda = kuda;
        this.vrOt = vrOt;
        this.vrPr = vrPr;
        this.cost = cost;
        this.datOt = datOt;
        this.datPr = datPr;
        this.tr = tr;
    }


    private String otkuda;
    private String kuda;
    private String vrOt;
    private String vrPr;
    private String cost;
    private String datOt;
    private String datPr;
    private String tr;
    /**
     * Getter и Setter для всех переменных.
     */
    public String getKuda() {
        return kuda;
    }

    public void setKuda(String kuda) {
        this.kuda = kuda;
    }

    public String getOtkuda() {
        return otkuda;
    }

    public void setOtkuda(String otkuda) {
        this.otkuda = otkuda;
    }


    public String getVrOt() {
        return vrOt;
    }

    public void setVrOt(String vrOt) {
        this.vrOt = vrOt;
    }

    public String getDatPr() {
        return datPr;
    }

    public void setDatPr(String datPr) {
        this.datPr = datPr;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getDatOt() {
        return datOt;
    }

    public void setDatOt(String datOt) {
        this.datOt = datOt;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getVrPr() {
        return vrPr;
    }

    public void setVrPr(String vrPr) {
        this.vrPr = vrPr;
    }


}
