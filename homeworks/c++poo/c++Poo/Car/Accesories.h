/*
 * Accesories.h
 *
 *  Created on: Jan 7, 2014
 *      Author: wolf
 */
#include <string>
using namespace std;
#ifndef ACCESORIES_H_
#define ACCESORIES_H_

class Accesories {
private:
	string name;
	int price;
public:
	Accesories();
	virtual ~Accesories();
	Accesories(string,int);
	void display();

	const string& getName() const {
		return name;
	}

	void setName(const string& name) {
		this->name = name;
	}

	int getPrice() const {
		return price;
	}

	void setPrice(int price) {
		this->price = price;
	}
};

#endif /* ACCESORIES_H_ */
