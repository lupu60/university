/*
 * Car.h
 *
 *  Created on: Jan 7, 2014
 *      Author: wolf
 */
#include <vector>
#include <string>
#include <stdio.h>
#include <iostream>
#include "Engine.h";
#include "Accesories.h"
#include "Body.h"
#include "Color.h"
using namespace std;
#ifndef CAR_H_
#define CAR_H_

class Car {
private:
	string name;
	Engine engine;
	Color color;
	Body body;
	vector<Accesories> list_accesories;
	int year;
	int km;
public:
	Car();
	virtual ~Car();
	Car(string, Engine, Color, Body, vector<Accesories>, int, int);
	void display();
	void Calculate_tprice();
	void Add_Km(int);
	void addAccesories(Accesories);
	void removeAccesories(string);
	void Display_List_accesories();
	void Change_List_accesories(vector<Accesories>);

	const Body& getBody() const {
		return body;
	}

	void setBody(const Body& body) {
		this->body = body;
	}

	const Color& getColor() const {
		return color;
	}

	void setColor(const Color& color) {
		this->color = color;
	}

	const Engine& getEngine() const {
		return engine;
	}

	void setEngine(const Engine& engine) {
		this->engine = engine;
	}

	int getKm() const {
		return km;
	}

	void setKm(int km) {
		this->km = km;
	}

	int getYear() const {
		return year;
	}

	void setYear(int year) {
		this->year = year;
	}
	const vector<Accesories>& getListAccesories() const {
		return list_accesories;
	}

	void setListAccesories(const vector<Accesories>& listAccesories) {
		list_accesories = listAccesories;
	}

	const string& getName() const {
		return name;
	}

	void setName(const string& name) {
		this->name = name;
	}

};

#endif /* CAR_H_ */
