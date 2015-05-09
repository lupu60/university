package com.mkyong.ws;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.mkyong.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World" + name;
    }

    @Override
    public String characterByDubling(String input) {
        StringBuilder output = new StringBuilder();
        String[] temp = input.split("");
        for (int i = 0; i < temp.length; i++) {
            output.append(temp[i]);
            output.append(temp[i]);
        }
        return output.toString();
    }

    @Override
    public String doublingTheString(String input) {
        StringBuilder output = new StringBuilder();
        output.append(input).append(input);
        return output.toString();
    }

    @Override
    public String mirroringTheString(String input) {
        StringBuilder output = new StringBuilder();
        output.append(input);
        return output.reverse().toString();
    }
    @Override
    public int determiningTheLength(String input) {
        StringBuilder output = new StringBuilder();
        output.append(input);
        return output.length();
    }

}