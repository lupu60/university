/*
 * Color.cpp
 *
 *  Created on: Jan 7, 2014
 *      Author: wolf
 */

#include "Color.h"
#include <iostream>
using namespace std;
Color::Color() {
	cl = "";
	price = 0;
}

Color::~Color() {
	// TODO Auto-generated destructor stub
}

Color::Color(string cl, int price) {
	this->cl = cl;
	this->price = price;

}

void Color::display() {
	cout << "[ Color: " << cl << " / Price= " << price <<"$ ]"<< endl;
}
