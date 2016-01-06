#include <iostream>
#include "Car.h"
#include <vector>
#include <string>
#include <stdio.h>
#include "Accesories.h"
#include "Body.h"
#include "Color.h"
#include "Engine.h";
using namespace std;
Car::Car() {

}

Car::~Car() {
	// TODO Auto-generated destructor stub
}
Car::Car(string name, Engine engine, Color color, Body body,
		vector<Accesories> list_accesories, int year, int km) {
	this->name = name;
	this->engine = engine;
	this->color = color;
	this->body = body;
	this->list_accesories = list_accesories;
	this->year = year;
	this->km = km;
}

void Car::Calculate_tprice() {
	int tprice_ac = 0;
	for (int i = 0; i < list_accesories.size(); ++i) {
		tprice_ac += list_accesories[i].getPrice();
	}
	int tprice = engine.getPrice() + color.getPrice() + tprice_ac;
	cout << tprice << "$" << endl;
}
void Car::Display_List_accesories() {
	for (int i = 0; i < list_accesories.size(); ++i) {
		cout << i << " ";
		list_accesories[i].display();
	}
}

void Car::addAccesories(Accesories accesories) {
	list_accesories.push_back(accesories);
}

void Car::removeAccesories(string accesories) {
	int i;
	for (i = 0; i < list_accesories.size(); ++i) {
		if (accesories == list_accesories[i].getName()) {
			list_accesories.erase(list_accesories.begin() + i);
			break;
		}
	}

}
void Car::Change_List_accesories(vector<Accesories> list_accesories2) {
	list_accesories = list_accesories2;
}
void Car::Add_Km(int km2) {
	km += km2;
}
void Car::display() {
	cout << name << endl;
	engine.display();
	color.display();
	body.display();
	cout << "List_accesories: " << endl;
	Display_List_accesories();
	cout << "Year= " << year << " / KM= " << km << " / Price = ";
	Calculate_tprice();

}

