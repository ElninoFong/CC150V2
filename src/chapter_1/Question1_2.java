package chapter_1;

/*
 * 1.2 
 * Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string.
 */
public class Question1_2 {
/*
 * TC:O(n), SC:O(1)
 * void reverse(char* str) {
 *     if (str) return;		// empty
 *     char* p = str;
 *     while (*p) {
 *         p++;
 *     }
 *     p--;
 *     char tmp;
 *     while (str < p) {
 *         tmp = *str;
 *         *str++ = *p;
 *         *p-- = tmp;
 *     }
 * }
 */
}
