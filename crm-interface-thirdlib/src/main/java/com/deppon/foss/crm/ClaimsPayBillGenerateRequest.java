
package com.deppon.foss.crm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * ��CRM���������⹤������������������ͨ������Ҫ��FOSS����������Ӧ����
 * 
 * <p>ClaimsPayBillGenerateRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ClaimsPayBillGenerateRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="claimType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="claimWay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businessType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deptNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="custNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="claimMoney" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="billNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creatorNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="responsibilityInfos" type="{http://www.deppon.com/esb/inteface/domain/crm}ResponsibilityInfo" maxOccurs="unbounded"/>
 *         &lt;element name="bankPayInfo" type="{http://www.deppon.com/esb/inteface/domain/crm}BankPayInfo" minOccurs="0"/>
 *         &lt;element name="payBillLastTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="paymentCategory" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClaimsPayBillGenerateRequest", propOrder = {
    "claimType",
    "claimWay",
    "businessType",
    "deptNo",
    "custNo",
    "claimMoney",
    "billNo",
    "creatorNo",
    "responsibilityInfos",
    "bankPayInfo",
    "payBillLastTime",
    "paymentCategory"
})
public class ClaimsPayBillGenerateRequest {

    @XmlElement(required = true)
    protected String claimType;
    @XmlElement(required = true)
    protected String claimWay;
    @XmlElement(required = true)
    protected String businessType;
    @XmlElement(required = true)
    protected String deptNo;
    @XmlElement(required = true)
    protected String custNo;
    @XmlElement(required = true)
    protected BigDecimal claimMoney;
    @XmlElement(required = true)
    protected String billNo;
    @XmlElement(required = true)
    protected String creatorNo;
    @XmlElement(required = true)
    protected List<ResponsibilityInfo> responsibilityInfos;
    protected BankPayInfo bankPayInfo;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date payBillLastTime;
    @XmlElement(required = true)
    protected String paymentCategory;

    /**
     * ��ȡclaimType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimType() {
        return claimType;
    }

    /**
     * ����claimType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimType(String value) {
        this.claimType = value;
    }

    /**
     * ��ȡclaimWay���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimWay() {
        return claimWay;
    }

    /**
     * ����claimWay���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimWay(String value) {
        this.claimWay = value;
    }

    /**
     * ��ȡbusinessType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * ����businessType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessType(String value) {
        this.businessType = value;
    }

    /**
     * ��ȡdeptNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptNo() {
        return deptNo;
    }

    /**
     * ����deptNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptNo(String value) {
        this.deptNo = value;
    }

    /**
     * ��ȡcustNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustNo() {
        return custNo;
    }

    /**
     * ����custNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustNo(String value) {
        this.custNo = value;
    }

    /**
     * ��ȡclaimMoney���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getClaimMoney() {
        return claimMoney;
    }

    /**
     * ����claimMoney���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setClaimMoney(BigDecimal value) {
        this.claimMoney = value;
    }

    /**
     * ��ȡbillNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * ����billNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillNo(String value) {
        this.billNo = value;
    }

    /**
     * ��ȡcreatorNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorNo() {
        return creatorNo;
    }

    /**
     * ����creatorNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorNo(String value) {
        this.creatorNo = value;
    }

    /**
     * Gets the value of the responsibilityInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the responsibilityInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResponsibilityInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponsibilityInfo }
     * 
     * 
     */
    public List<ResponsibilityInfo> getResponsibilityInfos() {
        if (responsibilityInfos == null) {
            responsibilityInfos = new ArrayList<ResponsibilityInfo>();
        }
        return this.responsibilityInfos;
    }

    /**
     * ��ȡbankPayInfo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BankPayInfo }
     *     
     */
    public BankPayInfo getBankPayInfo() {
        return bankPayInfo;
    }

    /**
     * ����bankPayInfo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BankPayInfo }
     *     
     */
    public void setBankPayInfo(BankPayInfo value) {
        this.bankPayInfo = value;
    }

    /**
     * ��ȡpayBillLastTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getPayBillLastTime() {
        return payBillLastTime;
    }

    /**
     * ����payBillLastTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayBillLastTime(Date value) {
        this.payBillLastTime = value;
    }

    /**
     * ��ȡpaymentCategory���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentCategory() {
        return paymentCategory;
    }

    /**
     * ����paymentCategory���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentCategory(String value) {
        this.paymentCategory = value;
    }

}
