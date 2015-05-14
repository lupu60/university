/*
 * Manager.h
 *
 *  Created on: Jan 15, 2014
 *      Author: wolf
 */

#ifndef MANAGER_H_
#define MANAGER_H_
using namespace std;
#include <string>
#include <vector>
#include "Employe.h"
class Manager: public Employe {
private:
	string departament;
	vector<Employe> employers;

public:
	Manager();
	virtual ~Manager();
	Manager(string,int,string,int,string,vector<Employe>);
	void display();
	void add_Employe(Employe);
	void remove_Employe(string);
	float medium_salary();

	const string& getDepartament() const {
		return departament;
	}

	void setDepartament(const string& departament) {
		this->departament = departament;
	}

	const vector<Employe>& getEmployers() const {
		return employers;
	}

	void setEmployers(const vector<Employe>& employers) {
		this->employers = employers;
	}
};

#endif /* MANAGER_H_ */
