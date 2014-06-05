
package com.deppon.foss.waybill;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>QueryDetailResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="QueryDetailResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wayBillDetailList" type="{http://www.deppon.com/esb/inteface/domain/waybillService}WayBillDetail" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryDetailResponse", propOrder = {
    "wayBillDetailList"
})
public class QueryDetailResponse {

    @XmlElement(required = true)
    protected List<WayBillDetail> wayBillDetailList;

    /**
     * Gets the value of the wayBillDetailList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wayBillDetailList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWayBillDetailList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WayBillDetail }
     * 
     * 
     */
    public List<WayBillDetail> getWayBillDetailList() {
        if (wayBillDetailList == null) {
            wayBillDetailList = new ArrayList<WayBillDetail>();
        }
        return this.wayBillDetailList;
    }

}
