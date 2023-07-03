#include <iostream>
#include <Windows.h>
#include <conio.h>
#include <stdio.h>
#include "Wilk.h"
#include "Organizm.h"
#include "Zwierze.h"
#include "Swiat.h"

#define specialKey -32

using namespace std;

int main() {
	int N, M;
	char input = NULL;
	char special = NULL;
	cout << "Projekt Programowanie Obiektowe: Kacper Karski, s186044 Informatyka gr II" << endl;
	cout << "Aby wylaczyc program kliknij q, aby wlaczyc specjalna umiejetnoc kliknij s, aby grac dowolny przycisk, sterowanie strzalki, minimalny rozmiar mapy 10x10 " << endl;
	cout << "Wpisz wymiar x: ";
	cin >> M;
	cout << endl;
	cout << "Wpisz wymiar y: ";
	cin >> N;
	cout << endl;
	Swiat d1(M, N);
	input = _getch();
	if (input == 'q') {
		return 0;
	}
	while (true) {
		system("cls");
		d1.rysujSwiat();
		input = _getch();
		if (input != 'q' && input != 's') {
			if (input == specialKey) {
				special = input;
			}
			else if (special == specialKey) {
				d1.wykoajTure(input);
				special = NULL;
			}
		}
		else if (input == 's') {
			d1.wykoajTure(input);
		}
		else {
			for (int i = 0; i < d1.organizmy.size(); i++) {
				delete d1.organizmy[i];
			}
			return 0;
		}
	}

	return 0;
}