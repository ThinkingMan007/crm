
package com.deppon.foss.crm;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  �ͻ��Ƿ�����������Ϣ�б�
 * 
 * <p>IsCustomerBlankOutResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="IsCustomerBlankOutResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultInfoList" type="{http://www.deppon.com/esb/inteface/domain/crm}IsCustomerBlankOutList" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IsCustomerBlankOutResponse", propOrder = {
    "resultInfoList"
})
public class IsCustomerBlankOutResponse {

    @XmlElement(required = true)
    protected List<IsCustomerBlankOutList> resultInfoList;

    /**
     * Gets the value of the resultInfoList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resultInfoList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResultInfoList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IsCustomerBlankOutList }
     * 
     * 
     */
    public List<IsCustomerBlankOutList> getResultInfoList() {
        if (resultInfoList == null) {
            resultInfoList = new ArrayList<IsCustomerBlankOutList>();
        }
        return this.resultInfoList;
    }

}
