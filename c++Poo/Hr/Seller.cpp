/*
 * Seller.cpp
 *
 *  Created on: Jan 9, 2014
 *      Author: wolf
 */
#include "Seller.h"
using namespace std;
#include <string>
#include <vector>
#include "Employe.h"
#include "../Car/Car.h"
#include "../Car/Accesories.h"
#include "../Car/Body.h"
#include "../Car/Color.h"
#include "../Car/Engine.h"
#include <iostream>

Seller::Seller() {
	// TODO Auto-generated constructor stub

}

Seller::~Seller() {
	// TODO Auto-generated destructor stub
}

Seller::Seller(string name, int year, string adress, int salary,
		vector<Car> cars): Employe(name, year, adress, salary) {
	this->cars = cars;
}

void Seller::add_Car(Car car) {
	cars.push_back(car);
}

void Seller::remove_Car(string name) {
	for (int i = 0; i < cars.size(); ++i) {
			if (name == cars[i].getName()) {
				cars.erase(cars.begin() + 1);

			}
		}
}
void Seller::display() {
	Employe::display();
		cout << "Cars" << endl;
		for (int i = 0; i < cars.size(); ++i) {
			cout << "[ " << i << " ]" << endl;
			cars[i].display();
		}
}
