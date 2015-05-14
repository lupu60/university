/*
 * Seller.h
 *
 *  Created on: Jan 9, 2014
 *      Author: wolf
 */
using namespace std;
#include <string>
#include <vector>
#include "Employe.h"
#include "../Car/Car.h"

#ifndef SELLER_H_
#define SELLER_H_

class Seller:public Employe {
private:
	vector<Car> cars;
public:

	Seller();
	virtual ~Seller();
	Seller(string,int,string,int,vector<Car>);
	void display();
	void add_Car(Car car);
	void remove_Car(string);

	const vector<Car>& getCars() const {
		return cars;
	}

	void setCars(const vector<Car>& cars) {
		this->cars = cars;
	}
};

#endif /* SELLER_H_ */
