package com.example.cw21;

import java.util.ArrayList;

/**
 *  An abstract class  with two subclasses Plant and Produce. That represents perishable items and implements the Deliverable interface.
 */
public abstract class Perishable implements Deliverable {
    private final SortingOffice sender;
    private final SortingOffice recipient;
    private boolean expired;
    private final ArrayList<SortingOffice> locations;

    /**
     * Constructor for a Perishable deliverables.
     * @param sender the sender's sorting office
     * @param recipient the recipient's sorting office
     */
    public Perishable(SortingOffice sender, SortingOffice recipient) {
        this.sender = sender;
        this.recipient = recipient;
        this.expired = false;
        this.locations = new ArrayList<>();
    }

    /**
     * Getter for the sender.
     * @return the sender
     */
    @Override
    public SortingOffice getSender() {
        return sender;
    }

    /**
     * Getter for the recipient.
     * @return the recipient
     */
    @Override
    public SortingOffice getRecipient() {
        return recipient;
    }

    /**
     * Checks if the item is expired or not.
     * @return if expired then true, else false
     */
    public boolean isExpired() {
        return expired;
    }

    /**
     * Sets the deliverable to expired
     */
    public void setExpired() {
        this.expired = true;
    }

    /**
     * Getter for the arraylist of locations.
     * @return the locations
     */
    public ArrayList<SortingOffice> getLocations() {
        return locations;
    }

    /**
     * Adds the sortingOffice to the locations arraylist.
     * @param sortingOffice the sorting office
     */
    @Override
    public void process(SortingOffice sortingOffice) {
        locations.add(sortingOffice);
    }

    /**
     * Getter for the receipt.
     * @return null
     */
    @Override
    public String getReceipt() {
        return null;
    }

}
