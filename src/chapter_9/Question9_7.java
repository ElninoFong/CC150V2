package chapter_9;

/*
 * 9.7
 * Implement the "paint fill" function that one might see on many image editing programs.
 * That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
 * fill in the surrounding area until the color changes from the original color.
 */
public class Question9_7 {
	public enum Color {
        Black, White, Red, Yellow, Green
	}
	
	public static String PrintColor(Color c) {
        switch(c) {
        case Black:
            return "B";
        case White:
            return "W";
        case Red:
            return "R";
        case Yellow:
            return "Y";
        case Green:
            return "G";
        }
        return "X";
	}
	
	public static void PaintFill(Color[][] screen, int x, int y, Color ncolor) {
        paintFill(screen, x, y, screen[x][y], ncolor);
	}
	
	
	public static void paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
		if (x < 0 || y < 0 || x >= screen.length || y >= screen[0].length) return;
		if (screen[x][y] != ocolor) return;
		
		screen[x][y] = ncolor;
		paintFill(screen, x - 1, y, ocolor, ncolor);
		paintFill(screen, x + 1, y, ocolor, ncolor);
		paintFill(screen, x, y - 1, ocolor, ncolor);
		paintFill(screen, x, y + 1, ocolor, ncolor);
	}
	
	
	/////////////
	public static void PrintScreen(Color[][] screen) {
	    for (int i = 0; i < screen.length; i++) {
	        for (int j = 0; j < screen[0].length; j++) {
	            System.out.print(PrintColor(screen[i][j]));
	        }
	        System.out.println();
	    }
	}
	 
	public static int randomInt(int n) {
		 return (int) (Math.random() * n);
	}
	 
	public static void main(String[] args) {
        int N = 10;
        Color[][] screen = new Color[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                screen[i][j] = Color.Black;
            }                       
        }
        for (int i = 0; i < 100; i++) {
            screen[randomInt(N)][randomInt(N)] = Color.Green;
        }
        PrintScreen(screen);
        PaintFill(screen, 2, 2, Color.White);
        System.out.println();
        PrintScreen(screen);
	}
}
