//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.06 at 06:46:41 PM IST 
//


package cpm.prashanth.spring.soap.api.alarmdetails;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alarmDetails" type="{http://prashanth.cpm/spring/soap/api/alarmdetails}alarmDetails"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "alarmDetails"
})
@XmlRootElement(name = "getAlarmByIdResponse")
public class GetAlarmByIdResponse {

    @XmlElement(required = true)
    protected AlarmDetails alarmDetails;

    /**
     * Gets the value of the alarmDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AlarmDetails }
     *     
     */
    public AlarmDetails getAlarmDetails() {
        return alarmDetails;
    }

    /**
     * Sets the value of the alarmDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlarmDetails }
     *     
     */
    public void setAlarmDetails(AlarmDetails value) {
        this.alarmDetails = value;
    }

}