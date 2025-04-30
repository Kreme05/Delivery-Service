# CS-115 Programming II - Coursework 2: Delivery Service Program
> ⚠️ Academic Integrity Notice  
> The code in this repository is part of my university coursework. It is shared for learning and portfolio purposes only. Please do not copy or submit this as your own work in any course or assignment.

## Assignment Structure

### Stage 1: SortingOffice Class
- Attributes: officeName, location, postcode, internationalPostcode, connectedOffices
- Stores the sorting office's name, location, postcode, and a list of connected offices.
- Methods:
  -   addConnection(SortingOffice office): Adds a new connection to another sorting office.
  -   getConnections(): Returns a list of connected sorting offices.
  -   toString(): Returns a string representation of the sorting office.

### Stage 2: Non-Perishable Deliverables
- Attributes: itemID, weight, isFragile, deliveryRoute
- Non-perishable items can be either fragile or not.
- Methods:
  - setFragile(boolean isFragile): Determines if the item is fragile.
  - calculateDeliveryRoute(): Determines the item’s delivery route.
- Rule: Fragile items break at certain sorting offices, and non-perishable items follow regular routes.

### Stage 3: Perishable Deliverables
- Attributes: itemID, weight, expiryDate, type (Produce, Plant)
- Handles perishable items like produce and plants with expiration dates.
- Methods:
  - setExpiryDate(Date expiryDate): Sets the expiry date.
  - isExpired(): Checks if the item has expired.
- Different rules for delivery based on the type of perishable item.

### Stage 4: Data Class
- Attributes: sortingOffices, deliverables
- Handles data-related functions, such as finding sorting offices by postcode or ID.
- Methods:
  - findSortingOfficeByID(String officeID): Returns a sorting office by its ID.
  - findDeliverableByID(String itemID): Returns a deliverable item by its ID.

Stage 5: Read Data from Files
- Methods:
  - readSortingOfficesFromFile(String filename): Reads sorting office data from a CSV file.
  - readDeliverablesFromFile(String filename): Reads deliverable item data from a CSV file.
- Note: This functionality allows dynamic loading of sorting office and item data.

Stage 6: Creating Connections
- Methods:
  - createConnection(SortingOffice office1, SortingOffice office2): Establishes a bidirectional connection between two sorting offices.
- Rule: Connections are made based on geographical proximity and postal rules (e.g., international connections).

Stage 7: Receipts
- Methods:
-   generateReceipt(Deliverable deliverable): Generates a receipt for a successfully delivered item.
-   Output: The receipt includes item ID, delivery route, and recipient details.
-   Saves the receipt to a text file.


## Learning Outcomes
- The importance of a testing code from each class
- Implement and use basic data structures (linked lists, arrays)
- Follow the code conventions to in my software development model
- Implement file I/O (read/write from CSV files)
- Use algorithms for sorting, searching, and route optimization
- Apply object-oriented programming principles (encapsulation, inheritance, polymorphism)




