
package org.example.client.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "OrderServiceService", targetNamespace = "http://example.org/", wsdlLocation = "http://localhost:8081/orders?wsdl")
public class OrderServiceService
    extends Service
{

    private final static URL ORDERSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException ORDERSERVICESERVICE_EXCEPTION;
    private final static QName ORDERSERVICESERVICE_QNAME = new QName("http://example.org/", "OrderServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/orders?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ORDERSERVICESERVICE_WSDL_LOCATION = url;
        ORDERSERVICESERVICE_EXCEPTION = e;
    }

    public OrderServiceService() {
        super(__getWsdlLocation(), ORDERSERVICESERVICE_QNAME);
    }

    public OrderServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ORDERSERVICESERVICE_QNAME, features);
    }

    public OrderServiceService(URL wsdlLocation) {
        super(wsdlLocation, ORDERSERVICESERVICE_QNAME);
    }

    public OrderServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ORDERSERVICESERVICE_QNAME, features);
    }

    public OrderServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OrderServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns OrderService
     */
    @WebEndpoint(name = "OrderServicePort")
    public OrderService getOrderServicePort() {
        return super.getPort(new QName("http://example.org/", "OrderServicePort"), OrderService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OrderService
     */
    @WebEndpoint(name = "OrderServicePort")
    public OrderService getOrderServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://example.org/", "OrderServicePort"), OrderService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ORDERSERVICESERVICE_EXCEPTION!= null) {
            throw ORDERSERVICESERVICE_EXCEPTION;
        }
        return ORDERSERVICESERVICE_WSDL_LOCATION;
    }

}
