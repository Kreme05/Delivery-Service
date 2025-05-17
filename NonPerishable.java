package com.example.cw21;

/**
 * Class to represent non-perishable items and implements the Deliverable interface.
 */
public class NonPerishable implements Deliverable {
    private final SortingOffice sender;
    private final SortingOffice recipient;
    private final double weight;
    private final boolean fragile;
    private boolean broken;

    /**
     * Constructor for an NonPerishable deliverables.
     * @param sender the sender's sorting office
     * @param recipient the recipient's sorting office
     * @param weight the weight of the item
     * @param fragile the items state
     */
    public NonPerishable(SortingOffice sender, SortingOffice recipient, double weight, boolean fragile) {
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
        this.fragile = fragile;
        this.broken = false;
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
     * Getter for the weight.
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Checks if the item is fragile or not.
     * @return if fragile then true, else false
     */
    public boolean isFragile() {
        return fragile;
    }

    /**
     * Checks if the item is broken or not.
     * @return if broken then true, else false
     */
    public boolean isBroken() {
        return broken;
    }

    /**
     * Checks if the item is fragile and from the location X560Y320CScotland. If both are true, true is returned.
     * @param sortingOffice the sorting office
     */
    @Override
    public void process(SortingOffice sortingOffice) {
        if (fragile && sortingOffice.getLocation().equals("X560Y320CScotland")) {
            broken = true;
        }
    }

    /**
     * Getter for the receipt.
     * @return the receipt
     */
    @Override
    public String getReceipt() {
        String receipt = "Non-Perishable delivered to " + getRecipient().getLocation() + ".";
        if (isFragile()) {
            receipt = "Fragile " + receipt;
        } else if (isFragile() && isBroken()) {
            receipt =  "Fragile " + receipt + "Item is broken.";
        }
        return receipt;
    }

}
