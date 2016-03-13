/*
 * Body.h
 *
 *  Created on: Jan 7, 2014
 *      Author: wolf
 */
#include <string>
using namespace std;
#ifndef BODY_H_
#define BODY_H_

class Body {
private:
	string body;
public:
	Body();
	virtual ~Body();
	Body(string);
	void display();

	const string& getBody() const {
		return body;
	}

	void setBody(const string& body) {
		this->body = body;
	}
};

#endif /* BODY_H_ */
