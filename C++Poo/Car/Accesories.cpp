/*
 * Accesories.cpp
 *
 *  Created on: Jan 7, 2014
 *      Author: wolf
 */

#include "Accesories.h"
#include <iostream>
using namespace std;
Accesories::Accesories() {
	name = "";
	price = 0;

}

Accesories::~Accesories() {
	// TODO Auto-generated destructor stub
}

Accesories::Accesories(string name, int price) {
	this->name = name;
	this->price = price;
}

void Accesories::display() {
	cout << "[ Name= " << name << " / Price= " << price << "$ ]" << endl;
}
