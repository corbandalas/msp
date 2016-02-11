
package org.datacontract.schemas._2004._07.system_collections;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.system_collections package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk_QNAME = new QName("http://schemas.datacontract.org/2004/07/System.Collections.Generic", "ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk");
    private final static QName _KeyValuePairOfstringValidationFailureReasontYKHRTWk_QNAME = new QName("http://schemas.datacontract.org/2004/07/System.Collections.Generic", "KeyValuePairOfstringValidationFailureReasontYKHRTWk");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.system_collections
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk }
     * 
     */
    public ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk createArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk() {
        return new ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk();
    }

    /**
     * Create an instance of {@link KeyValuePairOfstringValidationFailureReasontYKHRTWk }
     * 
     */
    public KeyValuePairOfstringValidationFailureReasontYKHRTWk createKeyValuePairOfstringValidationFailureReasontYKHRTWk() {
        return new KeyValuePairOfstringValidationFailureReasontYKHRTWk();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/System.Collections.Generic", name = "ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk")
    public JAXBElement<ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk> createArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk(ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk value) {
        return new JAXBElement<ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk>(_ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk_QNAME, ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyValuePairOfstringValidationFailureReasontYKHRTWk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/System.Collections.Generic", name = "KeyValuePairOfstringValidationFailureReasontYKHRTWk")
    public JAXBElement<KeyValuePairOfstringValidationFailureReasontYKHRTWk> createKeyValuePairOfstringValidationFailureReasontYKHRTWk(KeyValuePairOfstringValidationFailureReasontYKHRTWk value) {
        return new JAXBElement<KeyValuePairOfstringValidationFailureReasontYKHRTWk>(_KeyValuePairOfstringValidationFailureReasontYKHRTWk_QNAME, KeyValuePairOfstringValidationFailureReasontYKHRTWk.class, null, value);
    }

}
