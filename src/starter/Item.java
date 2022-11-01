package starter;

/**
 *   !!!DEPRECATED!!!
 */


public class Item {
	private ItemType iType;
	private String itemName;
	private int mutator;
	
	private static Item[] Items;
	
	public Item(ItemType i, String name, int m) {
		this.setiType(i);
		this.itemName = name;
		this.setMutator(m);
	}
	
	public static Item[] generateItemList(Item[] list) {
		list[0] = new Item(ItemType.STRENGTH, "Brawn (+2 STR)", 2);
		list[1]=  new Item(ItemType.AGILITY, "Swift Sandals (+1 AGL)", 1);
		list[2] = new Item(ItemType.AGILITY, "Speed (+2 AGL)", 2);
		list[3] = new Item(ItemType.CHARISMA, "Charm (+2 CHRS)", 2);
		list[4] = new Item(ItemType.DEFENSE, "Metallic Armor (+1 DEF)", 1);
		list[5] = new Item(ItemType.STRENGTH, "Full Power (+3 STR)", 3);
		list[6] = new Item(ItemType.DEFENSE, "Iron Body (+1 DEF)", 1);
		list[7] = new Item(ItemType.CHARISMA, "Photogenic Person (+2 CHRS)", 2);
		list[8] = new Item(ItemType.AGILITY, "Electric Movement (+3 AGL)", 3);
		list[9] = new Item(ItemType.AGILITY, "Flashstep (+3 AGL)", 3);
		list[10] = new Item(ItemType.CHARISMA, "Soothing Tunes (+3 CHRS)", 3);
		list[11] = new Item(ItemType.DEFENSE, "Density Cube (+2 DEF)", 2);
		list[12] = new Item(ItemType.AGILITY, "Sonido (+4 AGL)", 4);
		list[13] = new Item(ItemType.STRENGTH, "Burst Gate (+4 STR)", 4);
		list[14] = new Item(ItemType.CHARISMA, "Wizard's charm (+4 CHRS)", 4);
		list[15] = new Item(ItemType.DEFENSE, "Iron Defense (+3 DEF)", 3);
		list[16] = new Item(ItemType.DEFENSE, "Diamond Surface (+3 DEF)", 3);
		list[17] = new Item(ItemType.STRENGTH, "Muscular impact (+5 STR)", 5);
		list[18] = new Item(ItemType.CHARISMA, "Kindness (+5 CHRS)", 5);
		list[19] = new Item(ItemType.STRENGTH, "Warrior's Spirit (+6 STR)", 6);
		list[20] = new Item(ItemType.AGILITY, "Mach 5 (+5 AGL)", 5);
		list[21] = new Item(ItemType.AGILITY, "Hermes' footwear (+6 AGL)", 6);
		list[22] = new Item(ItemType.CHARISMA, "Compassion (+6 CHRS)", 6);
		list[23] = new Item(ItemType.DEFENSE, "Rogue's Guard (+4 DEF)", 4);
		list[24] = new Item(ItemType.STRENGTH, "Energy Flames (+7 STR)", 7);
		list[25] = new Item(ItemType.DEFENSE, "Shield Of Protection (+4 DEF)", 4);
		list[26] = new Item(ItemType.CHARISMA, "Helpful Nature (+7 CHRS)", 7);
		list[27] = new Item(ItemType.AGILITY, "Rocket shoes (+7 AGL)", 7);
		list[28] = new Item(ItemType.AGILITY, "Magister's shoes (+8 AGL)", 8);
		list[29] = new Item(ItemType.CHARISMA, "Persuasion (+8 CHRS)", 8);
        list[30] = new Item(ItemType.DEFENSE, "Hero's Shield (+5 DEF)", 5);
        list[31] = new Item(ItemType.AGILITY, "Old running shoes (+9 AGL)", 9);
        list[32] = new Item(ItemType.STRENGTH, "Super Power (+8 STR)", 8);
        list[33] = new Item(ItemType.CHARISMA, "Fake Gold (+9 CHRS)", 9);
        list[34] = new Item(ItemType.DEFENSE, "Endurance (+6 DEF)", 6);
        list[35] = new Item(ItemType.DEFENSE, "God's Shield (+7 DEF)", 7);
        list[36] = new Item(ItemType.STRENGTH, "Rage (+9 STR)", 9);
        list[37] = new Item(ItemType.CHARISMA, "Mage's Charm (+9 CHRS)", 9);
        list[38] = new Item(ItemType.STRENGTH, "200% Full Power (+9 STR)", 9);
        list[39] = new Item(ItemType.AGILITY, "Good running shoes (+9 AGL)", 9);
        list[40] = new Item(ItemType.AGILITY, "Premium running shoes (+10 AGL)", 10);
        list[41] = new Item(ItemType.CHARISMA, "Personality (+10 CHRS)", 10);
        list[42] = new Item(ItemType.DEFENSE, "Impenetrable Hide (+8 DEF)", 8);
        list[43] = new Item(ItemType.STRENGTH, "Infinity Sword (+10 STR)", 10);
        list[44] = new Item(ItemType.DEFENSE, "The Will To Protect (+9 DEF)", 9);
        list[45] = new Item(ItemType.CHARISMA, "Magical Mirror (+10 CHRS)", 10);
        list[46] = new Item(ItemType.AGILITY, "Lightspeed (+9 AGL)", 9);
        list[47] = new Item(ItemType.AGILITY, "Godspeed (+10 AGL)", 10);
        list[48] = new Item(ItemType.CHARISMA, "Fake Infinity Sword (+10 CHRS)", 10);
        list[49] = new Item(ItemType.DEFENSE, "Invicibility (+10 DEF)", 10);
        
        Items = list;
        
        return Items;
	}
	
	public Item[] getItemList() {
		return Items;
	}
	
	public Item getItem(int i) {
		return Items[i];
	}
	
	public static void printItemList() {
		System.out.println("--------------------------------\n");
		System.out.println("     INVENTORY ITEMS LIST      \n");
		System.out.println("--------------------------------\n");

		for(int i = 0; i < Items.length; i++) {
			System.out.println("Item " + i + ": " + Items[i].itemName + "\n");
		}

		System.out.println("--------------------------------\n");
	}
	
	public void printItemDetails() {
		System.out.println(this.itemName + " and this item alters " + this.getiType() + "\n");
	}

	public static void main(String[] args) {
		Items = new Item[50];
		generateItemList(Items);
		Items.toString();
	}

	public ItemType getiType() {
		return iType;
	}

	public void setiType(ItemType iType) {
		this.iType = iType;
	}

	public int getMutator() {
		return mutator;
	}

	public void setMutator(int mutator) {
		this.mutator = mutator;
	}
}
