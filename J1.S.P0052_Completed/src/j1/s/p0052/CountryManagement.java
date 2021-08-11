package j1.s.p0052;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CountryManagement {

    Scanner scan = new Scanner(System.in);
    Validation valid = new Validation();

    // display in mainmenu in screen 
    public void MainMenu() {
        System.out.println("1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "Enter your choice (1-5) :");
    }

    // check whether country is exist or not by inputted-code
    public Country CheckCountryExist(ArrayList<Country> listCountry, String code) {
        for (Country c : listCountry) {
            if (c.getCountryCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }

// check whether country is exist or not by inputted-name
    public Country GetCountryByName(ArrayList<Country> listCountry, String name) {
        for (Country c : listCountry) {
            if (c.getCountryName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    // display country by inputted-code
    public void SearchCountry(ArrayList<Country> listCountry) {
        String name = valid.checkInputString("country's name");

        Country c = GetCountryByName(listCountry, name);

        if (c != null) {
            System.out.printf("%-20s%-20s%-20s%-25s\n",
                    "Code", "Name", "Total Area", "Terrain");

            c.Display();
        } else {
            System.out.println("This country has doesn't exist !");
        }
    }

    // display country's list after sorting
    public void DisplaySortedCountry(ArrayList<Country> listCountry) {
        Collections.sort(listCountry, (c1, c2) -> {
            return c1.getCountryName().compareToIgnoreCase(c2.countryName);
        });

        NormalDisplay(listCountry);
    }

    // display country's list
    public void NormalDisplay(ArrayList<Country> listCountry) {
        System.out.printf("%-20s%-20s%-20s%-25s\n", "Code", "Name", "Total Area", "Terrain");
        for (Country country : listCountry) {
            country.Display();
        }
    }

    // add a record into country list
    public void AddCountry(ArrayList<Country> listCountry) {

        String code = valid.checkInputString("country's code");

        while (CheckCountryExist(listCountry, code) != null) {
            System.out.println("This country is already exist !");
            code = valid.checkInputString("country's code");
        }

        String name = valid.checkInputString("country's name");

        float total = valid.checkTotal("total area");

        String terrain = valid.checkInputString("terrain");

        listCountry.add(new Country(terrain, code, name, total));

        System.out.println("Adding a country is sucessfull !");

    }

}
