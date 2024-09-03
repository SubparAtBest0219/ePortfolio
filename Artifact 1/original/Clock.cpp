/*
Name: Marcus Burr
Professor: Bill Chan
Class Name: CS-210 Programming Languages
Date: 5/16/2022
*/


/* Sources
  The idea to use \t to tab over the 24 hour time display is courtesy of:
	http://www.cplusplus.com/forum/beginner/95182/
  The idea to use the time structure and respective libraries to display local time is from:
	https://stackoverflow.com/questions/35258285/how-to-use-localtime-s-with-a-pointer-in-c
  Exactly how to utilize the localtime_S command and manipulate the time came from:
	https://docs.microsoft.com/en-us/cpp/c-runtime-library/reference/localtime-s-localtime32-s-localtime64-s?view=msvc-170
  The idea to utilize setfill to add a zero on to each structure member came from:
	https://stackoverflow.com/questions/1714515/how-can-i-pad-an-int-with-leading-zeros-when-using-cout-operator
  The library and command utilized to clear the screen came from:
	https://mathbits.com/MathBits/CompSci/Introduction/clear.htm#:~:text=To%20clear%20the%20screen%20in,h%3E%20is%20needed
  File header format courtesy of:
	https://norcocollege.libguides.com/MLAguide/mlaformat
*/

#include <iostream>
#include <time.h>
#include <iomanip>
#include <stdlib.h>

using namespace std;

	// Function that displays a menu of accepted input, and describes functionality as prompted.
void displayMenu() {
	cout << "\t\t *************************" << endl;
	cout << "\t\t * 1 - Add One Hour      *" << endl;
	cout << "\t\t * 2 - Add One Minute    *" << endl;
	cout << "\t\t * 3 - Add One Second    *" << endl;
	cout << "\t\t * 4 - Exit Program      *" << endl;
	cout << "\t\t *************************" << endl;
}

	// Function that displays the time formatted in hh:mm:ss as prompted.
void displayTime(int& hour, int& minute, int& second, string& amPm, int& hour24, int& minute24, int& second24) {
	cout << "*************************\t" << "*************************" << endl;
	cout << "*    12-Hour Clock      *\t" << "*    24-Hour Clock      *" << endl;
	cout << "*    " << setfill('0') << setw(2) << hour << ":" << setfill('0') << setw(2) << minute << ":" << setfill('0') << setw(2) << second << amPm << "       *\t*" 
		 << "      " << setfill('0') << setw(2) << hour24 << ":" << setfill('0') << setw(2) << minute24 << ":" << setfill('0') << setw(2) << second24 << "         * " << endl;
	cout << "*************************\t" << "*************************" << endl;
	cout << endl;
}


	// Function that adds an hour to the times displayed, and resets the hours should the condition be met.
void addHour(int& hour, int& hour24) {
	hour = hour + 1;
	hour24 = hour24 + 1;

	if (hour > 12) {
		hour = 1;
	}
	
	if (hour24 == 24) {
		hour24 = 0;
	}
}
	// Function that adds a minute to the times displayed, that can also add an hour and reset minutes should the condition be met.
void addMinute(int& minute, int& minute24, int& hour, int& hour24) {
	minute = minute + 1;
	minute24 = minute24 + 1;

	if (minute > 59) {
		hour = hour + 1;
		minute = 0;
	}
	if (minute24 > 59) {
		hour24 = hour24 + 1;
		minute24 = 0;
	}
}
	// Function that adds a second to the times displayed, that can also add a minute and reset seconds should the condition be met.
void addSecond(int& second, int& second24, int& minute, int& minute24) {
	second = second + 1;
	second24 = second24 + 1;
	
	if (second > 59) {
		minute = minute + 1;
		second = 0;
	}
	if (second24 > 59) {
		minute24 = minute24 + 1;
		second24 = 0;
	}
}
	// Function that ends the loop depending on user input as prompted. 
bool endLoop(bool& terminate) {
	terminate = true;
	return terminate;
}


	// Function that handles menu input and calls the requested function.
void menuInput(int& userCommand, int& hour, int& hour24, int& minute, int& minute24, int& second, int& second24, bool& terminate) {
	switch (userCommand) {
	case 1:
		addHour(hour, hour24);
		break;
	case 2:
		addMinute(minute, minute24, hour, hour24);
		break;
	case 3:
		addSecond(second, second24, minute, minute24);
		break;
	case 4:
		endLoop(terminate);
		break;
	}
}


  
	// Main function that controls overall execution.
int main() {
	struct tm struct_Tm;
	time_t curr_LocalTime = time(0);
	localtime_s(&struct_Tm, &curr_LocalTime);
	int hour12 = struct_Tm.tm_hour%12;
	int minute12 = struct_Tm.tm_min;
	int second12 = struct_Tm.tm_sec;
	int hour24 = struct_Tm.tm_hour;
	int minute24 = struct_Tm.tm_min;
	int second24 = struct_Tm.tm_sec;
	string am_Pm; 
	bool terminate = false;

	// Loops input as prompted.
	while (terminate == false){
		system("CLS");

		if (hour24 > 11) {
			am_Pm = " P M";
		}
		else {
			am_Pm = " A M";
		}
		displayTime(hour12, minute12, second12, am_Pm , hour24, minute24, second24);
		displayMenu();
		int userCommand;
		cin >> userCommand;
		menuInput(userCommand, hour12, hour24, minute12, minute24, second12, second24, terminate);
	}
	return 0;
}

