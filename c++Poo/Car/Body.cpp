/*
 * Body.cpp
 *
 *  Created on: Jan 7, 2014
 *      Author: wolf
 */

#include "Body.h"
#include <iostream>
using namespace std;
Body::Body() {
	body = "";

}

Body::~Body() {
	// TODO Auto-generated destructor stub
}

Body::Body(string body) {
	this->body = body;
}

void Body::display() {
	cout << "[ Car_Body: " << body <<" ]"<< endl;
}
