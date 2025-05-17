package com.example.cw21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Class to hold data that is added to the "database".
 * You may add methods to this class.
 */
public class Data {
    /**
     * Attributes to save our data to the "database"
     */
    private static ArrayList<SortingOffice> sortingOffices = new ArrayList<>();
    private static Stack<Deliverable> deliverables = new Stack<>();
    private static Stack<Deliverable> processedDeliverables = new Stack<>();

    /**
     * Method to return the Stack of deliverables
     * @return stack of deliverables
     */
    public static Stack<Deliverable> getDeliverables(){
        return deliverables;
    }

    /**
     * Method to return the sorting offices
     * @return array list of sorting offices
     */
    public static ArrayList<SortingOffice> getSortingOffices(){
        return sortingOffices;
    }

    /**
     * Method to return the completed deliverables.
     * @return stack of completed deliverables.
     */
    public static Stack<Deliverable> getProcessedDeliverables(){
        return processedDeliverables;
    }

    /** DO NOT EDIT ANY CODE ABOVE THIS COMMENT. You may need to write additional methods below. **/

    /**
     * Adding the sortingOffice to the arraylist.
     * @param sortingOffice the sortingOffice being added
     */
    public static void addSortingOffice(SortingOffice sortingOffice) {
        sortingOffices.add(sortingOffice);
    }

    /**
     * Checking if the sortingOffice covers a particular postcode.
     * @param postcodes arraylist of postcodes
     * @return the sortingOffice if found, if not null
     */
    public static SortingOffice findSortingOffice(String postcodes){
        for (SortingOffice sortingOffice : sortingOffices) {
            if (sortingOffice.getPostcodes().contains(postcodes)) {
                return sortingOffice;
            }
        }
        return null;
    }

    /**
     * Checking if the sortingOffice covers a particular id.
     * @param id the sorting offices id
     * @return the sortingOffice if found, if not null
     */
    public static SortingOffice findSortingOffice(int id){
        for (SortingOffice sortingOffice : sortingOffices) {
            if (sortingOffice.getId() == id) {
                return sortingOffice;
            }
        }
        return null;
    }

    /**
     * Adds the data from each sortingOffice in the sortingOffices.txt to the SortingOffices arraylist.
     */
    public static void readSortingOffices() {
        try (BufferedReader br = new BufferedReader(new FileReader("sortingOffices.txt"))) {
            String line;
            while ( (line = br.readLine()) != null) {
                String[] data = line.split(" ");
                int x = Integer.parseInt(data[0]);
                int y = Integer.parseInt(data[1]);
                String country = data[2];
                boolean international = Boolean.parseBoolean(data[3]);
                ArrayList<String> postcodes = new ArrayList<>();
                String[] postCode = data[4].split(",");

                for (String postcode : postCode) {
                    postcodes.add(postcode);
                }
                SortingOffice sortingOffice = new SortingOffice(x, y, country, international, postcodes);
                sortingOffices.add(sortingOffice);
            }
        } catch (IOException e) {
            System.out.println("Error while reading file");
        }
    }

    /**
     * Adds the data from each deliverable in the deliverables.csv to the Deliverables stack.
     */
    public static void readDeliverables() {
        try (BufferedReader br = new BufferedReader(new FileReader("deliverables.csv"))) {
            String line;
            while ( (line = br.readLine()) != null) {
                String[] data = line.split(",");
                String senderInfo = data[0];
                String recipientInfo = data[1];
                String itemType = data[2];
                SortingOffice sender = null;
                SortingOffice recipient = null;

                for (SortingOffice sortingOffice : sortingOffices) {
                    if (sortingOffice.getPostcodes().contains(senderInfo)) {
                        sender = sortingOffice;
                    } else if (sortingOffice.getPostcodes().contains(recipientInfo)) {
                        recipient = sortingOffice;
                    }
                }

                if (data.length == 3) {
                    if (itemType.equals("Produce")) {
                        deliverables.push(new Produce(sender, recipient));
                    } else if (itemType.equals("Plant")) {
                        deliverables.push(new Plant(sender, recipient));
                    }
                } else if (data.length == 5) {
                    try {
                        double weight = Double.parseDouble(data[3]);
                        boolean fragile = Boolean.parseBoolean(data[4]);
                        deliverables.push(new NonPerishable(sender, recipient, weight, fragile));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid format for weight");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading file");
        }
    }

    /**
     * Adds connections to sorting offices that are international or are from the same country.
     */
    public static void addConnections() {
        for (int i = 0; i < sortingOffices.size(); i++) {
            SortingOffice sortingOffice1 = sortingOffices.get(i);
            if (sortingOffice1.isInternational()) {
                // makes sure there are no duplicates when making a connection as i!=j
                for (int j = i+1; j < sortingOffices.size(); j++) {
                    SortingOffice sortingOffice2 = sortingOffices.get(j);
                    // adds connection if both offices are international or if they are from the same countries
                    if (sortingOffice2.isInternational()) {
                        sortingOffice1.addConnection(sortingOffice2);
                        sortingOffice2.addConnection(sortingOffice1);
                    } else if (sortingOffice1.getCountry().equals(sortingOffice2.getCountry())) {
                        sortingOffice1.addConnection(sortingOffice2);
                        sortingOffice2.addConnection(sortingOffice1);
                    }
                }
            }
        }
    }

    /**
     * Writes the data from getReceipt into the file receipts.txt then prints it out.
     */
    public static void printReceipts(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("receipts.txt"))) {
            for (Deliverable deliverable : getProcessedDeliverables()) {
                bw.write(deliverable.getReceipt());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error while printing receipts");
        }
    }
}
