import java.util.*;
import java.util.Scanner;


public class CMIS242Asig2BrandstetterJ {

	private static abstract class Gift {

	    private String id;
	    protected char size;
	    protected double price;
	    
	    public Gift(String id) {
	        this.id = id;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setSize(char c) {
	        this.size = c;

	        updatePrice();
	    }

	    public char getSize() {
	        return this.size;
	    }

	    public double getPrice() {
	        return this.price;
	    }

	    public abstract void print();
	    public void edit(Scanner input) {
	        System.out.print("What size do you want: S, M, or L: ");
	        char size = Character.toUpperCase(input.next().charAt(0));
	        setSize(size);
	    }

	    protected double getFlatFee() {
	        switch (this.size) {
	        case 'S': return 19.99;
	        case 'M': return 29.99;
	        case 'L': return 39.99;
	        }
	        return 0;
	    }

	    protected abstract double getAdditionalFee();

	    protected void updatePrice() {
	        this.price = getFlatFee() + getAdditionalFee();
	    }
	    
	    public static String OrderId(String prefix) {
	    	  return prefix + (new OerId().nextInt(900) + 100);
	    	}
	    protected String getSizeDescription() {
	    	  switch (this.size) {
	    	    case 'S': return "small";
	    	    case 'M': return "medium";
	    	    case 'L': return "large";
	    	  }
	    	  return "";
	    	}
	}
	
	public static abstract class FruitBasket extends Gift {

	    private boolean hasCitrus;
	    public static final String PREFIX = "FB";

	    public FruitBasket(String id) {
	        super(id);
	    }

	    public void setHasCitrus(boolean hasCitrus) {
	        this.hasCitrus = hasCitrus;

	        updatePrice();
	    }

	    public int getNumberOfFruits() {
	        switch (this.size) {
	        case 'S': return 6;
	        case 'M': return 9;
	        case 'L': return 15;
	        }
	        return 0;
	    }
	    public void edit(Scanner input) {
	        super.edit(input);

	        System.out.println("Do you want citrus fruits included? true/false: ");
	        setHasCitrus(input.nextBoolean());
	    }
	    
	    
	    public String toString() {
	    	return
	    			"id: "+ getId()
	    			+ ": A " + getSizeDescription() + 
	    			" FruitBasket with " + getNumberOfFruits() + " fruits " + (this.hasCitrus ? "with" : "without")
	    			+ " citrus costing $" + String.format("%.02f", getPrice());
	    }

	    protected double getAdditionalFee() {
	        if (hasCitrus)
	            return 5.99;

	        return 0.0;
	    }
	}
	
	public static class SweetBasket extends Gift {

	    public boolean hasNuts;
	    public static final String PREFIX = "SB";
	    public SweetBasket(String id) {
	        super(id);
	    }

	    public void setHasNuts(boolean hasNuts) {
	        this.hasNuts = hasNuts;

	        updatePrice();
	    }
	    public void edit(Scanner input) {
	        super.edit(input);

	        System.out.println("Do you want nuts included? true/false: ");
	        setHasNuts(input.nextBoolean());
	    }

	    public void print() {
	    	System.out.println(getId() + ": A " + getSizeDescription() + " SweetBasket with " + 
	    (this.hasNuts ? "nuts" : "no nuts") + " costing $" + String.format("%.02f", getPrice()));
	    }

	    protected double getAdditionalFee() {
	        if (hasNuts)
	            return 4.49;

	        return 0.0;
	    }
	}
	
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    ArrayList<Gift> gifts = new ArrayList<Gift>();
	    int choice;
        FruitBasket f = new FruitBasket("FB3150");
        SweetBasket s = new SweetBasket("SB3160");
	    
	    do {
	        System.out.println("\nMENU");
	        System.out.println("1: Order a Gift Basket ");
	        System.out.println("2: Change Gift Basket");
	        System.out.println("3: Display Gift");
	        System.out.println("9: Exit program");

	        System.out.print("Enter your selection : ");
	        choice = input.nextInt();

	        switch (choice) {
	        
	            // Order new gift
	            case 1:
	                System.out.print("Do you want Fruit Basket (1) or Sweets Basket (2):");
	                int type = input.nextInt();
	                
	                switch (type) {
	                
	                    // Fruit Basket
	                case 1:{
	                String id = Gift.generateOrderId(FruitBasket.PREFIX);
	                FruitBasket gift = new FruitBasket(id);
	                        gift.edit(input);

	                        gifts.add(gift);
	                }
	                        break;
	                
	                    // Sweet Basket
	                    case 2:{
	                    	String id = Gift.generateOrderId(SweetBasket.PREFIX);
	                    	SweetBasket gift = new SweetBasket(id);
	                        gift.edit(input);

	                        gifts.add(gift);
	                    }
	                        break;

	                    default:
	                        System.out.print("Invalid choice\n");
	                }
	               break;

	            // Change gift
	            case 2:{
	                if (gifts.isEmpty()) {
	                        System.out.print("No gift has been ordered yet\n");
	                } else {
	                    Gift order = null;

	                    System.out.print("Enter order id: ");
	                    String id =input.next();
	                    
	                    
	                    for (Gift gift : gifts) {
	                        if (id.equals(gift.getId())) {
	                            order = gift;
	                            break;
	                        }
	                    }

	                    if (order == null) {
	                        System.out.print("No order with that id\n");
	                    } else {
	                    	order.print();
	                    	order.edit(input);
	                    }
	                }
	            }
	                break;

	            // Display gifts
	            case 3:{
	                if (gifts.isEmpty()) {
	                    System.out.print("No gift has been ordered yet\n");
	                } else {
	                    for (Gift gift : gifts) {
	                        gift.print();
	                    }
	                }
	            }
	                break;

	            case 9:
	                System.out.print("Thank you for using the program. Goodbye!\n");
	        }
	    }
	    while (choice != 9);
	    }
	}