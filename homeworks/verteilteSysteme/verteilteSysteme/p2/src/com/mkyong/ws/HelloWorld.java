package com.mkyong.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface HelloWorld {

    @WebMethod
    String getHelloWorldAsString(String name);

    @WebMethod
    String characterByDubling(String input);

    @WebMethod
    String doublingTheString(String input);

    @WebMethod
    String mirroringTheString(String input);
    @WebMethod
    int determiningTheLength(String input);

}