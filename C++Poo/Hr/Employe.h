/*
 * Employe.h
 *
 *  Created on: Jan 8, 2014
 *      Author: wolf
 */
#include <string>
using namespace std;
#ifndef EMPLOYE_H_
#define EMPLOYE_H_

class Employe {
protected:
	string name;
	int year;
	string adress;
	int salary;

public:
	Employe();
	virtual ~Employe();
	Employe(string, int, string, int);
	void raiseSalary(int);
	void reductionSalary(int);
	void display();

	const string& getAdress() const {
		return adress;
	}

	void setAdress(const string& adress) {
		this->adress = adress;
	}

	const string& getName() const {
		return name;
	}

	void setName(const string& name) {
		this->name = name;
	}

	int getSalary() const {
		return salary;
	}

	void setSalary(int salary) {
		this->salary = salary;
	}

	int getYear() const {
		return year;
	}

	void setYear(int year) {
		this->year = year;
	}
};

#endif /* EMPLOYE_H_ */
