package com.kolaysoft.peyk.soapclient.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for createDepartments complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="createDepartments"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="newDepartmentList" type="{http://service.ws.peyk.kolaysoft.com.tr/}departmentPyld" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createDepartments", propOrder = {
        "newDepartmentList"
})
public class CreateDepartments {

    protected List<DepartmentPyld> newDepartmentList;

    /**
     * Gets the value of the newDepartmentList property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the newDepartmentList property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNewDepartmentList().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DepartmentPyld }
     */
    public List<DepartmentPyld> getNewDepartmentList() {
        if (newDepartmentList == null) {
            newDepartmentList = new ArrayList<DepartmentPyld>();
        }
        return this.newDepartmentList;
    }

}
