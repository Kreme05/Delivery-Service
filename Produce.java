package com.example.cw21;

/**
 * A class that adds the SortingOffice to the locations arraylist and
 * keeps track of the most up to date SortingOffice location
 * and finds the current SortingOffice added to the list.
 */
public class Produce extends Perishable {
    private String currentLocation;
    private String trackingLocation;
    private SortingOffice sender;
    private SortingOffice recipient;

    /**
     * Constructor for Perishable produce.
     * @param sender    the sender's sorting office
     * @param recipient the recipient's sorting office
     */
    public Produce(SortingOffice sender, SortingOffice recipient) {
        super(sender, recipient);
        this.currentLocation = "";
        this.trackingLocation = "";
    }

    /**
     * Getter for the sender.
     * @return the sender
     */
    @Override
    public SortingOffice getSender() {
        return super.getSender();
    }

    /**
     * Getter for the recipient.
     * @return the recipient
     */
    @Override
    public SortingOffice getRecipient() {
        return super.getRecipient();
    }

    /**
     * Getter for the tracking location.
     * @return the trackingLocation
     */
    public String getTrackingLocation() {
        return trackingLocation;
    }

    /**
     * Getter for the current location.
     * @return the currentLocation
     */
    public String getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Adds the sortingOffice to the locations arraylist and
     * lists the locations of the sorting offices.
     * @param sortingOffice the sorting office
     */
    @Override
    public void process(SortingOffice sortingOffice) {
        super.process(sortingOffice);
        currentLocation = sortingOffice.getLocation();

        if (trackingLocation.isEmpty()) {
            trackingLocation = currentLocation;
        } else {
            trackingLocation += "," + currentLocation;
        }
    }

    /**
     * Getter for the receipt.
     * @return the receipt
     */
    @Override
    public String getReceipt() {
        String receipt = "Produce delivered to " + getRecipient().getLocation() + ". Produce route: " + getTrackingLocation() + ".";
        if (isExpired()) {
            receipt = "WARNING! Expired " + receipt;
        }
        return receipt;
    }

}
