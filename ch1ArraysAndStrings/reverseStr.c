//reverse a string in C

#include<stdio.h>

void reverse(char* str) {
  char* tail = str;

  if (str) { //null is 0 is false in C
    while (*tail) {
      tail++;
    }
    tail--;

    char temp;
    while (str < tail) {
      temp = *str;
      *str = *tail;
      *tail = temp;

      tail--;
      str++;
    }
  }
}

int main() {
  char str[] = "makeAWish";  //in c, it's already \0 terminated
  reverse(str);
  printf(str);
}
