/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.dataquality.domain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.dataquality.domain.TextValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.dataquality.domain.DomainPackage#getTextValue()
 * @model
 * @generated
 */
public interface TextValue extends LiteralValue {
    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see org.talend.dataquality.domain.DomainPackage#getTextValue_Value()
     * @model
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link org.talend.dataquality.domain.TextValue#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

} // TextValue
