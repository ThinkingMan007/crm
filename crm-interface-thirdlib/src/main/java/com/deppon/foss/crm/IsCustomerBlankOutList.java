
package com.deppon.foss.crm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>IsCustomerBlankOutList complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="IsCustomerBlankOutList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IsCustomerBlankOut" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IsCustomerBlankOutList", propOrder = {
    "customerCode",
    "isCustomerBlankOut"
})
public class IsCustomerBlankOutList {

    @XmlElement(required = true)
    protected String customerCode;
    @XmlElement(name = "IsCustomerBlankOut")
    protected boolean isCustomerBlankOut;

    /**
     * ��ȡcustomerCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * ����customerCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCode(String value) {
        this.customerCode = value;
    }

    /**
     * ��ȡisCustomerBlankOut���Ե�ֵ��
     * 
     */
    public boolean isIsCustomerBlankOut() {
        return isCustomerBlankOut;
    }

    /**
     * ����isCustomerBlankOut���Ե�ֵ��
     * 
     */
    public void setIsCustomerBlankOut(boolean value) {
        this.isCustomerBlankOut = value;
    }

}
