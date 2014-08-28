package chapter_10;

public class Question10_4MyBitSet {
	byte[] bits;
	
	public Question10_4MyBitSet(int n) {
		bits = new byte[n / 8 + 1];
	}
	
	public boolean get(int i) {
		byte b = bits[i / 8];
		boolean res = (b & (1 << (i % 8))) > 0;
		return res;
	}
	
	public void set(int i) {
		bits[i / 8] |= (1 << (i % 8));
	}
	
	public void clear(int i) {
		bits[i / 8] |= (~(1 << (i % 8)));
	}
}
