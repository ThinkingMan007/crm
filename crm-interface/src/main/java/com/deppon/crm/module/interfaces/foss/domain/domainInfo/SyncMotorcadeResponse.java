//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.29 at 04:46:52 下午 CST 
//


package com.deppon.crm.module.interfaces.foss.domain.domainInfo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				CRM处理数据结果返回给FOSS
 * 			
 * 
 * <p>Java class for SyncMotorcadeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SyncMotorcadeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultInfos" type="{http://www.deppon.com/crm/inteface/domain/}ResultInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SyncMotorcadeResponse", propOrder = {
    "resultInfos"
})
public class SyncMotorcadeResponse {

    @XmlElement(required = true)
    protected List<ResultInfo> resultInfos;

    /**
     * Gets the value of the resultInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resultInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResultInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResultInfo }
     * 
     * 
     */
    public List<ResultInfo> getResultInfos() {
        if (resultInfos == null) {
            resultInfos = new ArrayList<ResultInfo>();
        }
        return this.resultInfos;
    }

}
