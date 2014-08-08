package chapter_5;

/*
 * 5.8
 * A monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels to be stored in one byte. 
 * The screen has width w, where w is divisible by 8 (that is, no byte will be split across rows).
 * The height of the screen, of course, can be derived form the length of the array and the width.
 * Implement a function drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) which draws a horizhontal line from (x1, y) to (x2, y).
 */
public class Question5_8 {
	public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
		if (x1 > x2) {
			drawHorizontalLine(screen, width, x2, x1, y);
			return;
		}
		
		int rowStart = width / 8 * y;
		int beginOffset = x1 % 8;
		int beginIndex = rowStart + x1 / 8;
		int endOffset = x2 % 8;
		int endIndex = rowStart + x2 / 8;
		
		if (beginIndex != endIndex) {
			if (beginOffset == 0) {
				screen[beginIndex] = (byte) 0xff;	// err: miss cast
			} else {
				screen[beginIndex] = (byte) (0xff >> beginOffset);
			}
			
			for (int i = beginIndex + 1; i < endIndex; i++) {
				screen[i] = (byte) 0xff;
			}
			
			screen[endIndex] = (byte) ((~0) << (7 - endOffset));
		} else {
			screen[beginIndex]  = (byte) (((1 << (8 - beginOffset)) - 1) - ((1 << (7 - endOffset)) - 1));
		}
	}
	
	
	// answer
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int start_offset = x1 % 8;
        int first_full_byte = x1 / 8;
        if (start_offset != 0) {
            first_full_byte++;
        }
        
        int end_offset = x2 % 8;
        int last_full_byte = x2 / 8;
        if (end_offset != 7) {
            last_full_byte--;
        }
        
        // Set full bytes
        for (int b = first_full_byte; b <= last_full_byte; b++) {
            screen[(width / 8) * y + b] = (byte) 0xFF;
        }
        
        byte start_mask = (byte) (0xFF >> start_offset);
        byte end_mask = (byte) ~(0xFF >> (end_offset + 1));
        
        // Set start and end of line
        if ((x1 / 8) == (x2 / 8)) { // If x1 and x2 are in the same byte
            byte mask = (byte) (start_mask & end_mask);
            screen[(width / 8) * y + (x1 / 8)] |= mask;
        } else {
            if (start_offset != 0) {
                int byte_number = (width / 8) * y + first_full_byte - 1;
                screen[byte_number] |= start_mask;
            }
            if (end_offset != 7) {
                int byte_number = (width / 8) * y + last_full_byte + 1;
                screen[byte_number] |= end_mask;
            } 
        }
	}
	
	
	public static void printByte(byte b) {
        for (int i = 7; i >= 0; i--) {
            System.out.print((b >> i) & 1);
        }
	}
	
	public static int computeByteNum(int width, int x, int y) {
        return (width * y + x) / 8;
	}
	
	public static void printScreen(byte[] screen, int width) {
        int height = screen.length * 8 / width;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c+=8) {
                byte b = screen[computeByteNum(width, c, r)];
                printByte(b);
            }
            System.out.println("");
        }
	}
	
	public static void main(String[] args) {
        int width = 8 * 4;
        int height = 15;
        byte[] screen = new byte[width * height / 8];
        byte[] screen2 = new byte[width * height / 8];
        //screen[1] = 13;
        
        drawHorizontalLine(screen, width, 8, 30, 5);
        drawLine(screen2, width, 8, 30, 5);

        printScreen(screen, width);
        System.out.println("====================================");
        printScreen(screen2, width);
	}

}
