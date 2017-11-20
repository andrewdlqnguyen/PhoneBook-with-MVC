import java.util.ArrayList;
import java.util.List;
/**
 * 
 *
 * @author Andrew Nguyen
 */


public class AddressBook_main {
	private List<BuddyInfo> buddyInfo;
	
	public AddressBook_main() {
		this.buddyInfo = new ArrayList<>();
	}
	
	public void addBuddy(BuddyInfo aBuddyInfo) {
		if (aBuddyInfo != null) {
			this.buddyInfo.add(aBuddyInfo);
		}
	}
	
	//Print the whole list of AddressBook
	public String getAddressBook_mainList() {
		int count = 1;
		String result = "";
		for (BuddyInfo b: buddyInfo) {
			result += count + ": " + b.getName() + ", " + b.getAddress() + ", " + b.getPhoneNumber() + "\n";
			count++;
		}
		return result;
	}
	
	//Print the buddyList at the index in AddressBook
	public String getAddressBook_mainListIndex(int i) {
		String result = buddyInfo.get(i).getName();

		return result;
	}
	
	public BuddyInfo removeBuddy(int index) {
		if (index >= 0 && index < this.buddyInfo.size()) {
			return this.buddyInfo.remove(index);
		}
		return null;
	}
	
	public int getSize() {
		return buddyInfo.size();
	}
	
	public static void main(String args[]) {
		System.out.println("Address Book!");
		BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "647 999 1230");
		BuddyInfo buddy2 = new BuddyInfo("Andrew", "105 Arlington", "416 669 9668");
		BuddyInfo buddy3 = new BuddyInfo("Nick", "89 Turner", "905 670 2426");
		BuddyInfo buddy4 = new BuddyInfo("Susan", "12 Turner", "905 222 9516");
		
		AddressBook_main AddressBook_main = new AddressBook_main();
		AddressBook_main.addBuddy(buddy);
		AddressBook_main.addBuddy(buddy2);
		AddressBook_main.addBuddy(buddy3);
		AddressBook_main.addBuddy(buddy4);
		AddressBook_main.getAddressBook_mainList();
//		AddressBook_main.removeBuddy(0);
		
		GUI gui = new GUI(AddressBook_main);
	}
}

