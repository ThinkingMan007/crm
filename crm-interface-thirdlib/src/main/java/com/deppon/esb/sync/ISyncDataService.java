package com.deppon.esb.sync;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.2
 * 2012-05-30T17:41:05.996+08:00
 * Generated source version: 2.4.2
 * 
 */
@WebService(targetNamespace = "http://sync.crm.deppon.com/", name = "ISyncDataService")
@XmlSeeAlso({ObjectFactory.class})
public interface ISyncDataService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sync", targetNamespace = "http://sync.crm.deppon.com/", className = "com.deppon.esb.sync.Sync")
    @WebMethod
    @ResponseWrapper(localName = "syncResponse", targetNamespace = "http://sync.crm.deppon.com/", className = "com.deppon.esb.sync.SyncResponse")
    public java.lang.Boolean sync(
        @WebParam(name = "jsonRequest", targetNamespace = "")
        java.lang.String jsonRequest
    ) throws SyncDataException;
}
