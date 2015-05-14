/*
 * Driver.h
 *
 *  Created on: Jan 8, 2014
 *      Author: wolf
 */
using namespace std;
#include <string>
#include <vector>
#include "Employe.h"
#include "../Car/Car.h"

#ifndef DRIVER_H_
#define DRIVER_H_

class Driver:public Employe {
private:
	vector<Car> cars;
public:
	Driver();
	virtual ~Driver();
	Driver(string,int,string,int,vector<Car>);
	void display();
	void add_Car(Car car);
	void remove_Car(string);
	int consum_mediu();

	const vector<Car>& getCars() const {
		return cars;
	}

	void setCars(const vector<Car>& cars) {
		this->cars = cars;
	}
};

#endif /* DRIVER_H_ */
