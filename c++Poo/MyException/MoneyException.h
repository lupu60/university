/*
 * MoneyException.h
 *
 *  Created on: Jan 15, 2014
 *      Author: wolf
 */
#include <exception>
#include <string>
#ifndef MONEYEXCEPTION_H_
#define MONEYEXCEPTION_H_

class MoneyException: public std::exception {
private:
	string e;
public:
	 ~MoneyException() throw () {
	}
	;
	MoneyException(string x) {
		e = x;

	}
	virtual const char* what() const throw () {
		return e.c_str();
	}
};

#endif /* MONEYEXCEPTION_H_ */
