//============================================================================
// Name        : HomeWork.cpp
// Author      : Lupu Bogdan
// Version     :
// Copyright   :
// Description : Hello World in C++, Ansi-style
//============================================================================
#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>
#include <exception>
#include "../Car/Accesories.h"
#include "../Car/Body.h"
#include "../Car/Color.h"
#include "../Car/Engine.h"
#include "../Car/Car.h"
#include "../Hr/Employe.h"
#include "../Hr/Driver.h"
#include "../Hr/Seller.h"
#include "../Hr/Manager.h"
#include "../CMarkup/Markup.h"
#include "../MyException/MoneyException.h"
#include <string>
#include <sstream>
using namespace std;

string IntToString(int a) {
	string str;
	ostringstream temp;
	temp << a;
	return temp.str();
}

Car read_car(string sorce) {
	Car car;
	Engine engine;
	Color color;
	Body body;
	Accesories accesories;
	vector<Accesories> list_accesories;
	int t;
	CMarkup xml;
	xml.Load(MCD_T(sorce));
	xml.FindElem(MCD_T("CAR"));
	xml.IntoElem();
	xml.FindElem(MCD_T("NAME"));
	car.setName(xml.GetData());
	xml.FindElem(MCD_T("ENGINE"));
	xml.IntoElem();
	xml.FindElem(MCD_T("LKM"));
	t = atoi(xml.GetData().c_str());
	engine.setLkm(t);
	xml.FindElem(MCD_T("TYPE"));
	engine.setType(xml.GetData());
	xml.FindElem(MCD_T("CM3"));
	t = atoi(xml.GetData().c_str());
	engine.setCm3(t);
	xml.FindElem(MCD_T("HP"));
	t = atoi(xml.GetData().c_str());
	engine.setHp(t);
	xml.FindElem(MCD_T("PRICE"));
	t = atoi(xml.GetData().c_str());
	engine.setPrice(t);
	xml.OutOfElem();
	xml.FindElem(MCD_T("COLOR"));
	xml.IntoElem();
	xml.FindElem(MCD_T("CL"));
	color.setCl(xml.GetData());
	xml.FindElem(MCD_T("PRICE"));
	t = atoi(xml.GetData().c_str());
	color.setPrice(t);
	xml.OutOfElem();
	xml.FindElem(MCD_T("BODY"));
	body.setBody(xml.GetData());
	xml.FindElem("LIST_ACCESORIES");
	xml.IntoElem();
	while (xml.FindNode()) {
		xml.FindNode();
		xml.IntoElem();
		xml.FindElem(MCD_T("NAME"));
		accesories.setName(xml.GetData());

		xml.FindElem(MCD_T("PRICE"));
		t = atoi(xml.GetData().c_str());
		accesories.setPrice(t);

		list_accesories.push_back(accesories);
		xml.OutOfElem();
	}
	xml.ResetPos();
	xml.FindElem(MCD_T("CAR"));
	xml.IntoElem();
	xml.FindElem(MCD_T("YEAR"));
	t = atoi(xml.GetData().c_str());
	car.setYear(t);
	xml.FindElem(MCD_T("KM"));
	t = atoi(xml.GetData().c_str());
	car.setKm(t);
	car.setEngine(engine);
	car.setBody(body);
	car.setColor(color);
	list_accesories.pop_back();
	list_accesories.pop_back();
	list_accesories.pop_back();
	list_accesories.pop_back();
	car.setListAccesories(list_accesories);
	return car;
}
int main() {
	Car car;
	vector<Car> cars;
	for (int i = 1; i < 5; ++i) {

		cars.push_back(read_car("car" + IntToString(i) + ".xml"));
	}

	CMarkup xml;
	xml.Load(MCD_T("car1.xml"));

	Driver d1("d1", 25, "adress1", 200, cars);
	Seller s1("s1", 100, "adress2", 250, cars);

	vector<Employe> departament1;
	departament1.push_back(d1);
	departament1.push_back(s1);
	Manager m1("m1", 432, "adress3", 54432, "departament1", departament1);
	cout << "PARC AUTO" << endl;
	cout
			<< "#1 See stuff \n#2 Consum mediu \n#3 reduction salary\n#4 Add Accesory to car1\n#5 Medium Salary\n";
	int opt;
	cin >> opt;
	switch (opt) {
	case 1:
		d1.display();
		s1.display();
		m1.display();
		break;
	case 2:
		cout << d1.consum_mediu() << "%";
		break;
	case 3:
		try {
			d1.reductionSalary(1000);
		} catch (exception & e) {
			cout << e.what();
		}
		break;
	case 4:
		xml.FindElem(MCD_T("CAR"));
		xml.IntoElem();
		xml.FindElem("LIST_ACCESORIES");
		xml.IntoElem();
		xml.AddElem("ACCESORIES");
		xml.IntoElem();
		xml.AddElem("NAME", "A44432423");
		xml.AddElem("PRICE", "100");
		xml.Save(MCD_T("car1.xml"));
		break;
	case 5:
		cout << m1.medium_salary()<<endl;
		break;
	default:
		cout << "qwerty";
		break;
	}

	return 0;
}

