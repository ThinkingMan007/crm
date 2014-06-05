
package com.deppon.foss.waybill;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * �˵�������Ϣ
 * 
 * <p>WaybillCostInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="WaybillCostInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="costType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="costName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="costMoney" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WaybillCostInfo", propOrder = {
    "costType",
    "costName",
    "costMoney"
})
public class WaybillCostInfo {

    @XmlElement(required = true)
    protected String costType;
    @XmlElement(required = true)
    protected String costName;
    @XmlElement(required = true)
    protected BigDecimal costMoney;

    /**
     * ��ȡcostType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostType() {
        return costType;
    }

    /**
     * ����costType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostType(String value) {
        this.costType = value;
    }

    /**
     * ��ȡcostName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostName() {
        return costName;
    }

    /**
     * ����costName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostName(String value) {
        this.costName = value;
    }

    /**
     * ��ȡcostMoney���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCostMoney() {
        return costMoney;
    }

    /**
     * ����costMoney���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCostMoney(BigDecimal value) {
        this.costMoney = value;
    }

}
