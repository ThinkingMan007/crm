
package com.deppon.foss.crm;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ������Ϣ�����óе����ż��������
 * 
 * <p>ResponsibilityInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ResponsibilityInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responsibilityDeptCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="responsibilityMoney" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponsibilityInfo", propOrder = {
    "responsibilityDeptCode",
    "responsibilityMoney"
})
public class ResponsibilityInfo {

    @XmlElement(required = true)
    protected String responsibilityDeptCode;
    @XmlElement(required = true)
    protected BigDecimal responsibilityMoney;

    /**
     * ��ȡresponsibilityDeptCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibilityDeptCode() {
        return responsibilityDeptCode;
    }

    /**
     * ����responsibilityDeptCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibilityDeptCode(String value) {
        this.responsibilityDeptCode = value;
    }

    /**
     * ��ȡresponsibilityMoney���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getResponsibilityMoney() {
        return responsibilityMoney;
    }

    /**
     * ����responsibilityMoney���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setResponsibilityMoney(BigDecimal value) {
        this.responsibilityMoney = value;
    }

}
