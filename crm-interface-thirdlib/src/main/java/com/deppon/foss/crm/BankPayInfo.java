
package com.deppon.foss.crm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ����֧����Ϣ
 * 
 * <p>BankPayInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BankPayInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="payWay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountProperty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subbranchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subbranchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankProvinceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankProvinceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankCityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankCityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankPayInfo", propOrder = {
    "payWay",
    "accountName",
    "accountProperty",
    "accountNumber",
    "bankCode",
    "bankName",
    "subbranchCode",
    "subbranchName",
    "bankProvinceCode",
    "bankProvinceName",
    "bankCityCode",
    "bankCityName"
})
public class BankPayInfo {

    @XmlElement(required = true)
    protected String payWay;
    protected String accountName;
    protected String accountProperty;
    protected String accountNumber;
    protected String bankCode;
    protected String bankName;
    protected String subbranchCode;
    protected String subbranchName;
    protected String bankProvinceCode;
    protected String bankProvinceName;
    protected String bankCityCode;
    protected String bankCityName;

    /**
     * ��ȡpayWay���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayWay() {
        return payWay;
    }

    /**
     * ����payWay���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayWay(String value) {
        this.payWay = value;
    }

    /**
     * ��ȡaccountName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * ����accountName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountName(String value) {
        this.accountName = value;
    }

    /**
     * ��ȡaccountProperty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountProperty() {
        return accountProperty;
    }

    /**
     * ����accountProperty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountProperty(String value) {
        this.accountProperty = value;
    }

    /**
     * ��ȡaccountNumber���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * ����accountNumber���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * ��ȡbankCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * ����bankCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCode(String value) {
        this.bankCode = value;
    }

    /**
     * ��ȡbankName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * ����bankName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * ��ȡsubbranchCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubbranchCode() {
        return subbranchCode;
    }

    /**
     * ����subbranchCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubbranchCode(String value) {
        this.subbranchCode = value;
    }

    /**
     * ��ȡsubbranchName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubbranchName() {
        return subbranchName;
    }

    /**
     * ����subbranchName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubbranchName(String value) {
        this.subbranchName = value;
    }

    /**
     * ��ȡbankProvinceCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankProvinceCode() {
        return bankProvinceCode;
    }

    /**
     * ����bankProvinceCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankProvinceCode(String value) {
        this.bankProvinceCode = value;
    }

    /**
     * ��ȡbankProvinceName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankProvinceName() {
        return bankProvinceName;
    }

    /**
     * ����bankProvinceName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankProvinceName(String value) {
        this.bankProvinceName = value;
    }

    /**
     * ��ȡbankCityCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCityCode() {
        return bankCityCode;
    }

    /**
     * ����bankCityCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCityCode(String value) {
        this.bankCityCode = value;
    }

    /**
     * ��ȡbankCityName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCityName() {
        return bankCityName;
    }

    /**
     * ����bankCityName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCityName(String value) {
        this.bankCityName = value;
    }

}
