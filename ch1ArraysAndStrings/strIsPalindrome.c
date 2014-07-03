#include <stdio.h>

int isPalindrome(char* i) {
	if(i)
		return 0;

	char* tail = i;
	while (*tail)
		tail++;
	tail--;

	while(i<=tail){
		if(*i != *tail)
			return 0;
		i++;
		tail--;
	}
	return 1;
}

int main()
{
	char str[] = "goddog"; //null terminated? 	

	printf(isPalindrome(str));

	return 0;
}


