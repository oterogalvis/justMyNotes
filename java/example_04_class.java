public class example_04_class {
	public static int MAX_PEZ = 12;
	private String mCaracterName;
	private int mPezCount;
	public example_04_class(String caracterName){
		mCaracterName = caracterName;
		mPezCount = 0;
	}

	public void load() {
		mPezCount = MAX_PEZ;
	}

	public String getCaracterName(){
		return mCaracterName;
	}
}