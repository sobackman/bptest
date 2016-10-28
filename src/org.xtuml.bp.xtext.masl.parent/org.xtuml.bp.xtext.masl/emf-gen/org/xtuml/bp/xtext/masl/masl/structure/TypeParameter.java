/**
 * generated by Xtext 2.9.2
 */
package org.xtuml.bp.xtext.masl.masl.structure;

import org.xtuml.bp.xtext.masl.masl.types.TypeDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtuml.bp.xtext.masl.masl.structure.TypeParameter#isEnum <em>Enum</em>}</li>
 * </ul>
 *
 * @see org.xtuml.bp.xtext.masl.masl.structure.StructurePackage#getTypeParameter()
 * @model
 * @generated
 */
public interface TypeParameter extends TypeDeclaration {
	/**
	 * Returns the value of the '<em><b>Enum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum</em>' attribute.
	 * @see #setEnum(boolean)
	 * @see org.xtuml.bp.xtext.masl.masl.structure.StructurePackage#getTypeParameter_Enum()
	 * @model unique="false"
	 * @generated
	 */
	boolean isEnum();

	/**
	 * Sets the value of the '{@link org.xtuml.bp.xtext.masl.masl.structure.TypeParameter#isEnum <em>Enum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum</em>' attribute.
	 * @see #isEnum()
	 * @generated
	 */
	void setEnum(boolean value);

} // TypeParameter
