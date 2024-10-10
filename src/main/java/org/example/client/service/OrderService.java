
package org.example.client.service;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "OrderService", targetNamespace = "http://example.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OrderService {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "delete", targetNamespace = "http://example.org/", className = "org.example.client.service.Delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://example.org/", className = "org.example.client.service.DeleteResponse")
    @Action(input = "http://example.org/OrderService/deleteRequest", output = "http://example.org/OrderService/deleteResponse")
    public void delete(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "create", targetNamespace = "http://example.org/", className = "org.example.client.service.Create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://example.org/", className = "org.example.client.service.CreateResponse")
    @Action(input = "http://example.org/OrderService/createRequest", output = "http://example.org/OrderService/createResponse")
    public void create(
        @WebParam(name = "arg0", targetNamespace = "")
        Order arg0);

    /**
     * 
     * @return
     *     returns java.util.List<org.example.client.service.Order>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAll", targetNamespace = "http://example.org/", className = "org.example.client.service.GetAll")
    @ResponseWrapper(localName = "getAllResponse", targetNamespace = "http://example.org/", className = "org.example.client.service.GetAllResponse")
    @Action(input = "http://example.org/OrderService/getAllRequest", output = "http://example.org/OrderService/getAllResponse")
    public List<Order> getAll();

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "updateStatus", targetNamespace = "http://example.org/", className = "org.example.client.service.UpdateStatus")
    @ResponseWrapper(localName = "updateStatusResponse", targetNamespace = "http://example.org/", className = "org.example.client.service.UpdateStatusResponse")
    @Action(input = "http://example.org/OrderService/updateStatusRequest", output = "http://example.org/OrderService/updateStatusResponse")
    public void updateStatus(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}
