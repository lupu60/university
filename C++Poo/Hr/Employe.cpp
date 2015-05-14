/*
 * Employe.cpp
 *
 *  Created on: Jan 8, 2014
 *      Author: wolf
 */

#include "Employe.h"
#include <exception>
#include "../MyException/MoneyException.h"
#include <iostream>
Employe::Employe() {
	name = "";
	year = 0;
	adress = "";
	salary = 0;

}

Employe::~Employe() {
	// TODO Auto-generated destructor stub
}

Employe::Employe(string name, int year, string adress, int salary) {
	this->name = name;
	this->year = year;
	this->adress = adress;
	this->salary = salary;
}
void Employe::raiseSalary(int salary2) {
	salary += salary2;
}

void Employe::reductionSalary(int salary2) {
	if (salary2 > salary) {
		throw MoneyException("Reduction is too big");
	} else {
		salary -= salary2;
	}
}

void Employe::display() {
	cout << "[ Employe: Name= " << name << " / Year= " << year << " / Adress= "
			<< adress << " / Price= " << salary << "$ ]" << endl;
}

