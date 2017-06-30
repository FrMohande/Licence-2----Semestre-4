#include <stdio.h>
#include <unistd.h>

int main(int argc, char* argv[]){
	switch(getopt(argc, argv, "wcl")){
		case 'c':
			mcu_wc();
			break;
		case 'w':
			mcu_ww();
			break;
		case 'l':
			mcu_wl();
			break;
		default:
			printf("usage: mon_wc [-clw]\n");
	}
	
	return 0;
}