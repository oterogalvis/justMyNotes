public class example_04_class {
	public static final int MAX_PEZ = 12;
	private String mCaracterName;
	private int mPezCount;
	public example_04_class(String caracterName){
		mCaracterName = caracterName;
		mPezCount = 0;
	}

	public boolean dispense() {
		boolean wasDispense = false;
		if (!isEmpty()){
			mPezCount -= 1;
			wasDispense = true;
		}
		return wasDispense;
	}

	public boolean isEmpty(){
		return mPezCount == 0;
	}

	public void load() {
		mPezCount = MAX_PEZ;
	}

	public void load(int pezAmount) {
		int newAmount = pezAmount + mPezCount;
		if (newAmount > MAX_PEZ) {
			throw new IllegalArgumentException("Too many Pez !!!");
		}
		mPezCount = newAmount;
	}

	public String getCaracterName(){
		return mCaracterName;
	}
}