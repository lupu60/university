/*
 * Engine.cpp
 *
 *  Created on: Jan 7, 2014
 *      Author: wolf
 */

#include <iostream>
#include "Engine.h"
using namespace std;

Engine::Engine() {
	lkm = 0;
	type = "";
	hp = 0;
	cm3 = 0;
	price = 0;

}

Engine::~Engine() {
	// TODO Auto-generated destructor stub
}
Engine::Engine(int lkm, string type, int hp, int cm3, int price) {
	this->lkm = lkm;
	this->type = type;
	this->hp = hp;
	this->cm3 = cm3;
	this->price = price;
}
int Engine::getLkm() const{
	return lkm;
}

void Engine::setLkm(int lkm) {
	this->lkm = lkm;
}

int Engine::getHp() {
	return hp;
}

void Engine::setHp(int hp) {
	this->hp = hp;
}

int Engine::getPrice() {
	return price;
}

void Engine::setPrice(int price) {
	this->price = price;
}

string Engine::getType() {
	return type;
}

void Engine::setType(string type) {
	this->type = type;
}
void Engine::setCm3(int cm3) {
	this->cm3 = cm3;
}
int Engine::getCm3() {
	return cm3;
}
void Engine::display() {
	cout << "[ ENGINE: L/KM= " << lkm << "%" << " / Type= " << type << " / HP= "
			<< hp << " / Price= " << price << "$ ]" << endl;
}
