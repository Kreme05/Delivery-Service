package com.example.cw21;

import java.util.ArrayList;

/**
 * Class to represent a Sorting Office object.
 * You will heavily edit this class and therefore no further comments have been added.
 * Ensure you add comments when submitting.
 */
public class SortingOffice {
    private final int id;
    private final int x;
    private final int y;
    private final String location;
    private final String country;
    private final boolean international;
    private final ArrayList<String> postcodes;
    private final ArrayList<SortingOffice> connections;
    private static int firstID = 1;

    /**
     * Constructor for the SortingOffice.
     * @param x x-coordinate
     * @param y y-coordinate
     * @param country the country that the office is located
     * @param international the international status
     * @param postcodes arraylist of postcodes
     */
    public SortingOffice(int x, int y, String country, boolean international, ArrayList<String> postcodes) {
        this.x = x;
        this.y = y;
        this.country = country;
        this.international = international;
        this.postcodes = postcodes;
        this.id = firstID++;
        this.location = "X"+this.x+"Y"+this.y+"C"+this.country;
        this.connections = new ArrayList<SortingOffice>();
    }

    /**
     * Getter for the x-coordinate.
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for the y-coordinate.
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Getter for the country.
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Getter for the arraylist of postcodes.
     * @return the postcodes
     */
    public ArrayList<String> getPostcodes() {
        return postcodes;
    }

    /**
     * Getter for the countries' location.
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Getter for the id.
     * @return the SettingOffice's id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for the first id.
     * @return 1
     */
    public int getFirstID() {
        return firstID;
    }

    /**
     * Getter for the international status.
     * @return true if the country is international, else false
     */
    public boolean isInternational() {
        return international;
    }

    /**
     * Getter for the connections.
     * @return the arraylist of connections.
     */
    public ArrayList<SortingOffice> getConnections() {
        return connections;
    }

    /**
     * Adds a connection to the SortingOffice arraylist.
     * @param connection the sortingOffice being connected
     * @return the connections
     */
    public ArrayList<SortingOffice> addConnection(SortingOffice connection) {
        this.connections.add(connection);
        return connections;
    }

    /**
     * Returns a string in the format X[x]Y[y]C[country][international][postcodes]
     * @return a formatted string for the SortingOffice
     */
    @Override
    public String toString() {
        String information = location + international;

        for (String postcode : postcodes) {
            information += postcode;
        }
        return information;
    }
}
