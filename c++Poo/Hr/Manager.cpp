/*
 * Manager.cpp
 *
 *  Created on: Jan 15, 2014
 *      Author: wolf
 */

#include "Manager.h"
#include <string>
#include <vector>
#include "Employe.h"
#include <iostream>
Manager::Manager() {
	// TODO Auto-generated constructor stub

}

Manager::~Manager() {
	// TODO Auto-generated destructor stub
}

Manager::Manager(string name, int year, string adress, int salary,
		string departament, vector<Employe> employers) :
		Employe(name, year, adress, salary) {
	this->employers = employers;
	this->departament = departament;
}

void Manager::add_Employe(Employe employe) {
	employers.push_back(employe);
}

void Manager::remove_Employe(string name) {
	for (int i = 0; i < employers.size(); ++i) {
		if (name == employers[i].getName()) {
			employers.erase(employers.begin() + 1);

		}
	}
}
float Manager::medium_salary() {
	float m_s;
	for (int i = 0; i < employers.size(); ++i) {
		m_s+=employers[i].getSalary();
	}
return m_s/employers.size();
}

void Manager::display() {
	Employe::display();
	cout << "Departament " << departament << endl;
	cout << "Employers" << endl;
	for (int i = 0; i < employers.size(); ++i) {
		cout << "[ " << i << " ]" << endl;
		employers[i].display();
	}
}

