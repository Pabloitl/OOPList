package test;

import weatherapi.Weather;

public class TestAPI {
    public static void main(String[] args) {
        try {
            System.out.println(Weather.askTemp("London"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
