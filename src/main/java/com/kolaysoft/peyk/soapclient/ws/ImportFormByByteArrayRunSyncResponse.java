package com.kolaysoft.peyk.soapclient.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for importFormByByteArrayRunSyncResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="importFormByByteArrayRunSyncResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://service.ws.peyk.kolaysoft.com.tr/}documentResultPyld" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "importFormByByteArrayRunSyncResponse", propOrder = {
        "_return"
})
public class ImportFormByByteArrayRunSyncResponse {

    @XmlElement(name = "return")
    protected DocumentResultPyld _return;

    /**
     * Gets the value of the return property.
     *
     * @return possible object is
     * {@link DocumentResultPyld }
     */
    public DocumentResultPyld getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     *
     * @param value allowed object is
     *              {@link DocumentResultPyld }
     */
    public void setReturn(DocumentResultPyld value) {
        this._return = value;
    }

}
