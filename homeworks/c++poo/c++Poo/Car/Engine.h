/*
 * Engine.h
 *
 *  Created on: Jan 7, 2014
 *      Author: wolf
 */
#include <string>
using namespace std;
#ifndef ENGINE_H_
#define ENGINE_H_

class Engine {
private:
	int lkm;
	string type;
	int cm3;
	int hp;
	int price;
public:
	Engine();
	virtual ~Engine();
	Engine(int, string, int, int, int);

	int getLkm() const;
	string getType();
	int getCm3();
	int getHp();
	int getPrice();

	void setLkm(int x);
	void setType(string x);
	void setCm3(int x);
	void setHp(int x);
	void setPrice(int x);
	void display();

};

#endif /* ENGINE_H_ */
