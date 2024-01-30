#include <stdio.h>
#include <string.h>

int count_operations(char pseudo_code[]) {

    int comparison_count = 0;
    int arithmetic_count = 0;
    
    // Loop through each character in the pseudo code
    for (int i = 0; i < strlen(pseudo_code); i++) {
        // Count the number of comparisons
        if ((pseudo_code[i] == '=' && pseudo_code[i+1] == '=') || pseudo_code[i] == '<' || pseudo_code[i] == '>') {
            comparison_count++;
        }
        // Count the number of arithmetic operations
        if (pseudo_code[i] == '+' || pseudo_code[i] == '-' || pseudo_code[i] == '*' || pseudo_code[i] == '/') {
            arithmetic_count++;
        }
        
    }    

    // Print the operation counts
    printf("Comparisons: %d\n", comparison_count);
    printf("Arithmetic: %d\n", arithmetic_count);
    return 0;
}

int main() {
    char pseudo_code[] = "if (x == y) {\n\t z = x + y\n\t print(z)\n}";
    count_operations(pseudo_code);
    return 0;
}
