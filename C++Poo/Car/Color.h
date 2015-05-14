/*
 * Color.h
 *
 *  Created on: Jan 7, 2014
 *      Author: wolf
 */

#include <string>
using namespace std;
#ifndef COLOR_H_
#define COLOR_H_

class Color {
private:
	string cl;
	int price;
public:
	Color();
	virtual ~Color();
	Color(string, int);
	void display();
	const string& getCl() const {
		return cl;
	}

	void setCl(const string& cl) {
		this->cl = cl;
	}

	int getPrice() const {
		return price;
	}

	void setPrice(int price) {
		this->price = price;
	}
};

#endif /* COLOR_H_ */
