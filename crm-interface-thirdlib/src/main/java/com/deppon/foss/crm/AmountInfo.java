
package com.deppon.foss.crm;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ���������
 * 
 * <p>AmountInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="AmountInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="waybillNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isSender" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="custType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prePayment" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="arrivePayment" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="serviceFee" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="refund" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountInfo", propOrder = {
    "waybillNo",
    "isSender",
    "custType",
    "prePayment",
    "arrivePayment",
    "serviceFee",
    "refund"
})
public class AmountInfo {

    @XmlElement(required = true)
    protected String waybillNo;
    protected boolean isSender;
    @XmlElement(required = true)
    protected String custType;
    @XmlElement(required = true)
    protected BigDecimal prePayment;
    @XmlElement(required = true)
    protected BigDecimal arrivePayment;
    @XmlElement(required = true)
    protected BigDecimal serviceFee;
    @XmlElement(required = true)
    protected BigDecimal refund;

    /**
     * ��ȡwaybillNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaybillNo() {
        return waybillNo;
    }

    /**
     * ����waybillNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaybillNo(String value) {
        this.waybillNo = value;
    }

    /**
     * ��ȡisSender���Ե�ֵ��
     * 
     */
    public boolean isIsSender() {
        return isSender;
    }

    /**
     * ����isSender���Ե�ֵ��
     * 
     */
    public void setIsSender(boolean value) {
        this.isSender = value;
    }

    /**
     * ��ȡcustType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustType() {
        return custType;
    }

    /**
     * ����custType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustType(String value) {
        this.custType = value;
    }

    /**
     * ��ȡprePayment���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrePayment() {
        return prePayment;
    }

    /**
     * ����prePayment���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrePayment(BigDecimal value) {
        this.prePayment = value;
    }

    /**
     * ��ȡarrivePayment���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getArrivePayment() {
        return arrivePayment;
    }

    /**
     * ����arrivePayment���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setArrivePayment(BigDecimal value) {
        this.arrivePayment = value;
    }

    /**
     * ��ȡserviceFee���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    /**
     * ����serviceFee���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setServiceFee(BigDecimal value) {
        this.serviceFee = value;
    }

    /**
     * ��ȡrefund���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRefund() {
        return refund;
    }

    /**
     * ����refund���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRefund(BigDecimal value) {
        this.refund = value;
    }

}
