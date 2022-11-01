package starter;
import java.util.HashMap;


/**equip method: if there is no other item equipped in that equip category (STRENGTH, AGILITY, DEFENSE, CHARISMA categories), 
*then equip that item in that category. 
*
*if there is another item equipped in that equip category, then swap. 
*
*  !!!DEPRECATED CLASS!!!
*
*/

public class Inventory {

	private static HashMap<Integer, Item> backpack;
	private static Item[] itemList;
	public static boolean equipped;
	private int index;

	public void openBackpack() {
		
	}
	
	public void itemDetails(Item i) {
		i.printItemDetails();
	}


	public boolean equip (Item i, Character c) {
		

		if (isInBackpack(i, backpack)) { 
			// item temp is at index
			Item temp = backpack.get(index);
			backpack.put(index, i);
			backpack.put(backpack.size() + 1, temp);
		}
		
		// equip the item 
		else {
			if(i.getiType() == ItemType.STRENGTH) {
				int temp = c.getStrength();
				c.setStrength(temp + i.getMutator());
				equipped = true;
			}
			else if(i.getiType() == ItemType.AGILITY) {
				int temp = c.getAgility();
				c.setAgility(temp + i.getMutator());
				equipped = true;
			}
			else if(i.getiType() == ItemType.DEFENSE) {
				int temp = c.getDefense();
				c.setDefense(temp + i.getMutator());
				equipped = true;
			}
			else if(i.getiType() == ItemType.CHARISMA) {
				int temp = c.getCharisma();
				c.setCharisma(temp + i.getMutator());
				equipped = true;
			}
		}
		
		return equipped;
		
 	}
	
	public boolean isInBackpack (Item item, HashMap<Integer, Item> backpack) {
		for (index = 0; index < backpack.size(); index++) {
			if (backpack.get(index) == item) {
				return true;
			}
		}
		if (index == backpack.size()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		backpack = new HashMap<Integer, Item>();
		itemList = new Item[50];
		Item.generateItemList(itemList);
		backpack.put(0, itemList[2]);
		backpack.get(0).printItemDetails();
		Item.printItemList();
	}
}