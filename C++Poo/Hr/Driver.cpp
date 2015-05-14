/*
 * Driver.cpp
 *
 *  Created on: Jan 8, 2014
 *      Author: wolf
 */

#include "Driver.h"
using namespace std;
#include <string>
#include <vector>
#include "Employe.h"
#include "../Car/Car.h"
#include "../Car/Accesories.h"
#include "../Car/Body.h"
#include "../Car/Color.h"
#include "../Car/Engine.h"
#include "math.h"
#include <iostream>

Driver::Driver() {
	// TODO Auto-generated constructor stub

}

Driver::~Driver() {
	// TODO Auto-generated destructor stub
}

Driver::Driver(string name, int year, string adress, int salary,
		vector<Car> cars) :
		Employe(name, year, adress, salary) {
	this->cars = cars;
}
void Driver::add_Car(Car car) {
	cars.push_back(car);
}

void Driver::remove_Car(string name) {
	for (int i = 0; i < cars.size(); ++i) {
		if (name == cars[i].getName()) {
			cars.erase(cars.begin() + 1);

		}
	}
}
void Driver::display() {
	Employe::display();
	cout << "Cars" << endl;
	for (int i = 0; i < cars.size(); ++i) {
		cout << "[ " << i << " ]" << endl;
		cars[i].display();
	}
}

int Driver::consum_mediu() {
	int consum_mediu;
	int x;
	for (int i = 0; i < cars.size(); ++i) {
		x = cars[i].getEngine().getLkm();
		consum_mediu += x;
	}
	return consum_mediu / cars.size();
}
