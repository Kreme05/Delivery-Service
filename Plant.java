package com.example.cw21;

/**
 * A class that adds the SortingOffice to the locations arraylist
 * and sets the item to expired once it is more than processed 3 times.
 */
public class Plant extends Perishable {
    private SortingOffice sender;
    private SortingOffice recipient;

    /**
     * Constructor for Perishable plants.
     * @param sender    the sender's sorting office
     * @param recipient the recipient's sorting office
     */
    public Plant(SortingOffice sender, SortingOffice recipient) {
        super(sender, recipient);
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
     * Adds the sortingOffice to the locations arraylist and
     * if the plant is processed more than 3 times it becomes expired.
     * @param sortingOffice the sorting office
     */
    @Override
    public void process(SortingOffice sortingOffice) {
        super.process(sortingOffice);

        if (getLocations().size() > 3) {
            setExpired();
        }
    }

    /**
     * Getter for the receipt.
     * @return the receipt
     */
    @Override
    public String getReceipt() {
        String receipt = "Plant delivered to " + getRecipient().getLocation() + ".";
        if (isExpired()) {
            receipt = "WARNING! Expired " + receipt;
        }
        return receipt;
    }
}
